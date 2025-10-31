/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.Model;

import MiniPlay.GUI.*;

import javax.swing.*;
import java.awt.*;

/**
 * Manages the MiniPlay GUIS.
 * Holds references to all the Main Menu and all the game GUIS and handles the switching between them
 */
public class GameManager {

    private MainMenu mainMenu;
    private TickTackToeGUI TickTackToeGUI;
    private CrosswordGUI crosswordGUI;
    private WordSearchGUI wordSearchGUI;
    private JFrame window_root_frame;
    private JPanel display_panel;
    /**
     * Constructs the GameManager and initializes all game GUIs.
     */
    public GameManager() {
        // Creates the main menu and all the other GUIS
        window_root_frame = new JFrame("MiniPlay");
        display_panel = new JPanel();
        display_panel.setVisible(true);
        window_root_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window_root_frame.setSize(new Dimension(1390,800));
        window_root_frame.setVisible(true);
        window_root_frame.add(display_panel);

        mainMenu = new MainMenu(this, this.display_panel);

        TickTackToeGUI = new TickTackToeGUI(this, this.display_panel);
        TickTackToeGUI.hide();

        crosswordGUI = new CrosswordGUI(this, this.display_panel);
        crosswordGUI.hide();

        wordSearchGUI = new WordSearchGUI(this, this.display_panel);
        wordSearchGUI.hide();
    }

    /**
     * Start a game based off of user selection
     *
     * @param gameName - name of game to start
     */
    public void startGame(String gameName) {
        // Game startup logic
        mainMenu.hide();

        switch (gameName) {
            case "TicTacToe":
                TickTackToeGUI.display();
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
        if (TickTackToeGUI != null) TickTackToeGUI.hide();
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
