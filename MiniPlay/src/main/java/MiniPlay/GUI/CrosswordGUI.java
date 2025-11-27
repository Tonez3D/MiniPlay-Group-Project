/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import MiniPlay.Model.Grid;
import MiniPlay.Model.Crossword.CrosswordCell;

import javax.swing.*;
import java.awt.*;

public class CrosswordGUI {

    private JPanel panel;

    public CrosswordGUI(GameManager manager) {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(UITheme.BG);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Crossword", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setForeground(UITheme.ACCENT_DARK);
        panel.add(title, BorderLayout.NORTH);

        Grid grid = new Grid(10, 10, CrosswordCell.class, null);
        panel.add(grid, BorderLayout.CENTER);

        JButton back = UIStyled.backButton("Back to Main Menu", manager);
        panel.add(back, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}