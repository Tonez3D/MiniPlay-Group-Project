/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.Model;

import MiniPlay.GUI.*;
import javax.swing.*;
import java.awt.*;


public class GameManager {

    private JFrame window;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    private MainMenu mainMenu;
    private TicTacToeGUI ticTacToeGUI;
    private CrosswordGUI crosswordGUI;
    private WordSearchGUI wordSearchGUI;

    // Card names
    public static final String MAIN_MENU   = "MAIN_MENU";
    public static final String TICTACTOE   = "TICTACTOE";
    public static final String CROSSWORD   = "CROSSWORD";
    public static final String WORDSEARCH  = "WORDSEARCH";

    public GameManager() {

        // ----- Window -----
        window = new JFrame("MiniPlay");
        Image icon = new ImageIcon(getClass().getResource("/Images/miniplay_logo.png")).getImage();
        window.setIconImage(icon);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(1200, 900));

        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);
        window.setContentPane(cardPanel);

        // ----- Create screens -----
        mainMenu      = new MainMenu(this);
        ticTacToeGUI  = new TicTacToeGUI(this);
        crosswordGUI  = new CrosswordGUI(this);
        wordSearchGUI = new WordSearchGUI(this);

        // ----- Register screens with CardLayout -----
        cardPanel.add(mainMenu.getPanel(),      MAIN_MENU);
        cardPanel.add(ticTacToeGUI.getPanel(),  TICTACTOE);
        cardPanel.add(crosswordGUI.getPanel(),  CROSSWORD);
        cardPanel.add(wordSearchGUI.getPanel(), WORDSEARCH);


        // Show main menu first
        showMainMenu();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


    public void showMainMenu() {
        cardLayout.show(cardPanel, MAIN_MENU);
    }

    public void startTicTacToe() {
        cardLayout.show(cardPanel, TICTACTOE);
    }

    public void startCrossword() {
        cardLayout.show(cardPanel, CROSSWORD);
    }

    public void startWordSearch() {
        cardLayout.show(cardPanel, WORDSEARCH);
    }
    
}