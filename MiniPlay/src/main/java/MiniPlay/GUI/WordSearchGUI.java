package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import MiniPlay.Model.Grid;
import MiniPlay.Model.WordSearch.WordSearchCell;

import javax.swing.*;
import java.awt.*;

/**
 * Word Search game screen.
 * Currently generates a random letter grid you can click to highlight.
 */
public class WordSearchGUI {

    private JPanel panel;

    public WordSearchGUI(GameManager manager) {

        panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Word Search (prototype)", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        Grid grid = new Grid(10, 10, WordSearchCell.class);
        panel.add(grid, BorderLayout.CENTER);

        JButton backBtn = new JButton("Back to Main Menu");
        backBtn.addActionListener(e -> manager.showMainMenu());
        panel.add(backBtn, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}