/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miniplay;

import MiniPlay.GUI.MainMenu;
import MiniPlay.Model.GameManager;
import javax.swing.*;
/**
 * Entry point for the MiniPlay application.
 * This class initializes the GameManager and launches the main menu
 */
public class MiniPlay {

    /**
     * Starts the MiniPlay Application. 
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameManager manager = new GameManager();  // central logic handler
            manager.displayMainMenu();                           // show main menu through GameManager
        });
    }
}
