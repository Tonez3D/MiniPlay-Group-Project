/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import MiniPlay.Model.Grid;
import MiniPlay.Model.TicTacToe.TicTacToeGame;
import MiniPlay.Model.TicTacToe.TicTacToeGridCell;

import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI {

    private JPanel panel;
    private TicTacToeGame game;
    private Grid grid;

    public TicTacToeGUI(GameManager manager) {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(UITheme.BG);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setForeground(UITheme.ACCENT_DARK);
        panel.add(title, BorderLayout.NORTH);

        game = new TicTacToeGame();
        grid = new Grid(3, 3, TicTacToeGridCell.class, new Object[]{ game, manager, this });
        panel.add(grid, BorderLayout.CENTER);

        JButton back = UIStyled.backButton("Back to Main Menu", manager);
        panel.add(back, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void refreshBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                var cell = grid.getCell(r, c);
                cell.setBackground(null); // clear any highlight
                cell.render();
            }
        }
        panel.repaint();
    }

    public void animateWin(int[][] winningCells) {
        if (winningCells == null) return;

        final int[] index = {0};

        Timer timer = new Timer(200, e -> {
            if (index[0] >= winningCells.length) {
                ((Timer) e.getSource()).stop();
                return;
            }
            int r = winningCells[index[0]][0];
            int c = winningCells[index[0]][1];

            var cell = grid.getCell(r, c);
            cell.setBackground(UITheme.BUTTON);   // highlight color
            cell.repaint();

            index[0]++;
        });
        timer.setRepeats(true);
        timer.start();
    }
}