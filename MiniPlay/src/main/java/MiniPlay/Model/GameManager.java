/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.Model;

import MiniPlay.GUI.*;

/**
 * Manages the MiniPlay GUIS.
 * Holds references to all the Main Menu and all the game GUIS and handles the switching between them
 */
public class GameManager {
    
    private MainMenu mainMenu;
    private tttGUI TttGUI;
    private CrosswordGUI crosswordGUI;
    private WordSearchGUI wordSearchGUI;
    
    /**
     * Constructs the GameManager and initializes all game GUIs.
     */
    public GameManager() {
        // Creates the main menu and all the other GUIS
        mainMenu = new MainMenu(this);
        TttGUI = new tttGUI(this);
        crosswordGUI = new CrosswordGUI(this);
        wordSearchGUI = new WordSearchGUI(this);
    }
    
    /**
     * Start a game based off of user selection
     * @param gameName - name of game to start
     */
    
    public void startGame(String gameName) {
        // Game startup logic
        mainMenu.hide();
        
        switch (gameName) {
            case "TicTacToe":
                TttGUI.display();
                break;
            case "Crossword":
                crosswordGUI.display();
                break;
            case "WordSearch":
                wordSearchGUI.display();
                break;
            default:
                System.err.println("Unknown Game: " + gameName);
                
        }
        
    }
    
    /**
     * Returns to Main Menu.
     */
    
    public void returnToMain() {
        //Hides all game GUIS and displays main menu
        if (TttGUI != null) TttGUI.hide();
        if (crosswordGUI != null) crosswordGUI.hide();
        if (wordSearchGUI != null) wordSearchGUI.hide();
        mainMenu.display();
        
    }
    /**
     * Displays Main Menu.
    */
    public void displayMainMenu() {
        mainMenu.display();
    }
}
