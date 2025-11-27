/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import MiniPlay.Model.Grid;
import MiniPlay.Model.WordSearch.WordSearchCell;
import MiniPlay.Model.WordSearch.WordSearchGame;

import javax.swing.*;
import java.awt.*;

public class WordSearchGUI {

    private JPanel panel;
    private WordSearchGame game;
    private JPanel wordPanel;

    public WordSearchGUI(GameManager manager) {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(UITheme.BG);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Word Search", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setForeground(UITheme.ACCENT_DARK);
        panel.add(title, BorderLayout.NORTH);

        // Create game logic
        game = new WordSearchGame();

        // Sidebar for word list
        wordPanel = new JPanel();
        wordPanel.setBackground(UITheme.PANEL);
        wordPanel.setLayout(new BoxLayout(wordPanel, BoxLayout.Y_AXIS));
        updateWordList();  // draw initial list

        panel.add(wordPanel, BorderLayout.WEST);

        // Pass BOTH the game AND this GUI into each cell
        Grid grid = new Grid(10, 10, WordSearchCell.class, new Object[]{ game, this });
        panel.add(grid, BorderLayout.CENTER);

        // Back button
        JButton back = UIStyled.backButton("Back to Main Menu", manager);
        panel.add(back, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void updateWordList() {
        wordPanel.removeAll();

        for (String w : game.getWords()) {

            JLabel lbl;

            if (game.isWordFound(w)) {
                // Strike-through the found word
                lbl = new JLabel("<html><strike>" + w + "</strike></html>");
            } else {
                lbl = new JLabel(w);
            }

            lbl.setFont(new Font("Serif", Font.PLAIN, 18));
            lbl.setForeground(UITheme.ACCENT_DARK);
            lbl.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            wordPanel.add(lbl);
        }

        wordPanel.revalidate();
        wordPanel.repaint();
    }
}