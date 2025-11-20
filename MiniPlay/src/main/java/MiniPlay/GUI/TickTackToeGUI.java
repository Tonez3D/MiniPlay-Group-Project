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
import java.awt.*;

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

        JPanel ui = new Grid(3, 3, new TicTacToeGridCell(1, 1));
        ui.setSize(ui.getMaximumSize());
        JButton back_button = new JButton("Return to Main Menu");
        back_button.addActionListener(e -> manager.returnToMain());

        ui.setVisible(true);

        JPanel panel = new JPanel();
        panel.setMinimumSize(new Dimension(500,200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ui.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        back_button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(300));
        panel.add(ui);
        //panel.add(Box.createVerticalStrut(500));

        panel.add(back_button);
        frame.setSize(800,800);

        frame.add(panel);
        JLabel t = new JLabel("WEEE");
        t.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        //panel.add(t);
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
