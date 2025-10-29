/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;
import MiniPlay.Model.GameManager;
import javax.swing.*;

/**
 * GUI for Tic Tac Toe game
 */
public class tttGUI {
    private JFrame frame;
    private GameManager manager;
    /**
     * Construct Tic Tac Toe GUI
     * @param manager the GameManager controlling this screen
     */
    public tttGUI(GameManager manager) {
        //TODO Set up 3x3 board and message area
        //Below is a temp placeholder to show that the game manager works
        this.manager = manager;

        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Tic Tac Toe (placeholder)", SwingConstants.CENTER);
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
     * Display Tic Tac Toe GUI.
     */
    public void display() {
        // Show GUI
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    /**
     * Hide the Tic Tac Toe GUI.
     */
    public void hide() {
        frame.setVisible(false);
    }
    
}
