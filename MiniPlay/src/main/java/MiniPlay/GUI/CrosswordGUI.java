/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;
import MiniPlay.Model.GameManager;
import javax.swing.*;

/**
 * GUI for Crossword Puzzle game
 */
public class CrosswordGUI {
    private JFrame frame;
    private GameManager manager;
    
     /**
     * Setup Crossword GUI
     * @param manager
     */
    public CrosswordGUI(GameManager manager) {
        this.manager = manager;
        //TODO Setup crossword grid and clue panels
        //Below is a temp placeholder to show that the game manager works
        this.manager = manager;

        frame = new JFrame("Crossword");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Crossword (placeholder)", SwingConstants.CENTER);
        JButton back = new JButton("Return to Main Menu");
        back.addActionListener(e -> manager.returnToMain());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        back.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(50));
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));
        panel.add(back);

        frame.getContentPane().add(panel);
    }

    /**
     * Display Crossword GUI
     */
    public void display() {
        // Show GUI
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    public void hide() {
        frame.setVisible(false);
    }
    
}
