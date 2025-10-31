/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;
import MiniPlay.Model.GameManager;
import javax.swing.*;

/**
 * GUI for Word Search game
 */

public class WordSearchGUI {
    private JPanel frame;
    //private GameManager manager;
     
    /**
     * Creates Word Search GUI
     * @param manager the GameManager controlling this screen
     */
    public WordSearchGUI(GameManager manager, JPanel root_frame) {
        //TODO Create puzzle grid, word list, buttons
        //Below is a temp placeholder to show that the game manager works
        //this.manager = manager;


        frame = new JPanel();
        root_frame.add(frame);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Word Search (placeholder)", SwingConstants.CENTER);
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

        frame.add(panel);
    }

    /**
     * Display Word Search GUI.
     */
    public void display() {
        // Show GUI
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    /**
     * Hide Word Search GUI.
     */
    public void hide() {
        frame.setVisible(false);
    }
}
