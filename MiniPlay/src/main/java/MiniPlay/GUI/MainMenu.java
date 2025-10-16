/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;

import javax.swing.*;

/**
 * Main menu GUI for MiniPlay
 * Allows users to select game and exit
 */
public class MainMenu {
    
    private JFrame frame;

    /**
     * Constructs main menu GUI
     */
    public MainMenu() {
        // Initialize JFrame and add buttons
        frame = new JFrame("Mini Play");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Welcome to Mini Play!");
        frame.getContentPane().add(label);
        
        frame.pack();
    }

    /**
     * Display main menu
     */
    public void display() {
        // Show the main menu
        frame.setVisible(true);
    }
    /**
     * Hide the main menu
     */
    public void hide() {
        frame.setVisible(false);
    }
    
}
