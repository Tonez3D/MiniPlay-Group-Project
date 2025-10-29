/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.Model;

import MiniPlay.GUI.*;

/**
 * Manages the MiniPlay app as a whole.
 * Is responsible for switching between games and handling the game sessions
 */
public class GameManager {
    /**
     * Constructs a GameManager instance
     */
    
    private MainMenu mainMenu;
    private tttGUI TttGUI;
    private CrosswordGUI crosswordGUI;
    private WordSearchGUI wordSearchGUI;
    
    public GameManager() {
        // Creates the main menu and passes this manager to it
        mainMenu = new MainMenu(this);
        TttGUI = new tttGUI(this);
        crosswordGUI = new CrosswordGUI(this);
    }
    
    /**
     * Start whichever game user selects from MainGUI
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
     * Return to main main/mainGUI
     */
    
    public void returnToMain() {
        //Hides all game GUIS and displays main menu
        TttGUI.hide();
        crosswordGUI.hide();
        wordSearchGUI.hide();
        mainMenu.display();
        
    }
    
    public void displayMainMenu() {
        mainMenu.display();
    }
}
