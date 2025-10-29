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
    }

    /**
     * Display Crossword GUI
     */
    public void display() {
        // Show GUI
    }
    public void hide() {
        frame.setVisible(false);
    }
    
}
