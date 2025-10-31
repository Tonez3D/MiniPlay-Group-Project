/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;

import javax.swing.*;
import MiniPlay.Model.GameManager;

/**
 * Main menu GUI for MiniPlay
 * Allows users to select game and exit
 */
public class MainMenu {
    
    private JPanel frame;
    //private GameManager gameManager;

    /**
     * Constructs main menu GUI
     * @param gameManager the central GameManager instance
     */
    public MainMenu(GameManager gameManager, JPanel root_frame) {
        //this.gameManager = gameManager;

        frame = new JPanel();

        root_frame.add(frame);

        // Use a panel with vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title label
        JLabel label = new JLabel("Welcome to Mini Play!", SwingConstants.CENTER);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(50, 0, 20, 0)); // spacing from top

        // Buttons
        JButton tttButton = new JButton("Play Tic Tac Toe");
        JButton crosswordButton = new JButton("Play Crossword");
        JButton wordSearchButton = new JButton("Play WordSearch");
        JButton exitButton = new JButton("Exit");

        // Center buttons horizontally
        tttButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        crosswordButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        wordSearchButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        // Add actions
        tttButton.addActionListener(e -> {
            hide();
            gameManager.startGame("TicTacToe");
        });

        crosswordButton.addActionListener(e -> {
            hide();
            gameManager.startGame("Crossword");
        });
        
        wordSearchButton.addActionListener(e -> {
            hide();
            gameManager.startGame("WordSearch");
        });

        exitButton.addActionListener(e -> System.exit(0));

        // Add components to panel
        panel.add(label);
        panel.add(tttButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(crosswordButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(wordSearchButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(exitButton);

        frame.add(panel);
    }

    /**
     * Display main menu
     */
    public void display() {
        // Show the main menu
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    /**
     * Hide the main menu
     */
    public void hide() {
        frame.setVisible(false);
    }
    
}
