/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import MiniPlay.Model.Grid;
import MiniPlay.Model.GridCell;
import MiniPlay.Model.TickTacToe.TicTacToeGridCell;

import javax.swing.*;

/**
 * GUI for Tic Tac Toe game
 */
public class TickTackToeGUI {
    private JPanel frame;
    //private GameManager manager;

    /**
     * Construct Tic Tac Toe GUI
     * @param manager the GameManager controlling this screen
     */
    public TickTackToeGUI(GameManager manager, JPanel root_frame) {
        //TODO Set up 3x3 board and message area
        //Below is a temp placeholder to show that the game manager works
        //this.manager = manager;

        frame = new JPanel();
        root_frame.add(frame);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel ui = new Grid(1, 3, new TicTacToeGridCell(10, 10));
        JButton back_button = new JButton("Return to Main Menu");
        back_button.addActionListener(e -> manager.returnToMain());

        ui.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ui.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        back_button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(50));
        panel.add(ui);
        panel.add(Box.createVerticalStrut(10));

        panel.add(back_button);


        frame.add(panel);
    }

    /**
     * Display Tic Tac Toe GUI.
     */
    public void display() {
        // Show GUI
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    /**
     * Hide the Tic Tac Toe GUI.
     */
    public void hide() {
        frame.setVisible(false);
    }
    
}
