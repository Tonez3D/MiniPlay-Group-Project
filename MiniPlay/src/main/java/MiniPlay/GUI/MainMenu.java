package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import javax.swing.*;
import java.awt.*;

/**
 * Main menu screen – lets the user pick a mini-game.
 */
public class MainMenu {

    private JPanel panel;

    public MainMenu(GameManager manager) {

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("MiniPlay", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton ticTacToeBtn = new JButton("Play Tic-Tac-Toe");
        JButton crosswordBtn = new JButton("Play Crossword");
        JButton wordSearchBtn = new JButton("Play Word Search");
        JButton colorFillBtn = new JButton("Color Fill Demo");

        ticTacToeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        crosswordBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        wordSearchBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        colorFillBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        ticTacToeBtn.addActionListener(e -> manager.startTicTacToe());
        crosswordBtn.addActionListener(e -> manager.startCrossword());
        wordSearchBtn.addActionListener(e -> manager.startWordSearch());
        colorFillBtn.addActionListener(e -> manager.startColorFill());

        panel.add(Box.createVerticalStrut(40));
        panel.add(title);
        panel.add(Box.createVerticalStrut(30));
        panel.add(ticTacToeBtn);
        panel.add(Box.createVerticalStrut(10));
        panel.add(crosswordBtn);
        panel.add(Box.createVerticalStrut(10));
        panel.add(wordSearchBtn);
        panel.add(Box.createVerticalStrut(10));
        panel.add(colorFillBtn);
    }

    public JPanel getPanel() {
        return panel;
    }
}