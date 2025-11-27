package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import MiniPlay.Model.Grid;
import MiniPlay.Model.TicTacToe.TicTacToeGridCell;

import javax.swing.*;
import java.awt.*;

/**
 * Tic-Tac-Toe game screen.
 */
public class TicTacToeGUI {

    private JPanel panel;

    public TicTacToeGUI(GameManager manager) {

        panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        // 3x3 grid of TicTacToeGridCell
        Grid grid = new Grid(3, 3, TicTacToeGridCell.class);
        panel.add(grid, BorderLayout.CENTER);

        JButton backBtn = new JButton("Back to Main Menu");
        backBtn.addActionListener(e -> manager.showMainMenu());
        panel.add(backBtn, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}