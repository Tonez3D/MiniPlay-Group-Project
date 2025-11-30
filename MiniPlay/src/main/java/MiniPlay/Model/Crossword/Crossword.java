/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.Model.Crossword;

import MiniPlay.Model.GameManager;

/**
 * Manages Crossword Puzzle Game
 * Handles grid, clues, and checks player input
 */
public class Crossword {
    
    /**
     * Creates a crossword game with specified size
     * @param rows - number of rows
     * @param cols - number of columns
     */
    public Crossword(int rows, int cols) {
        // Create crossword grid
    }
    
    /**
     * Add clue to crossword
     * @param clue - clue object
     */
    public void addWord(GameManager clue) {
        // TODO: Word adding
    }

    /**
     * Check if entered word is correct
     * @param row - row of starting cell
     * @param col - column of starting cell
     * @param word - word entered by player
     * @return true - if correct
     */
    public boolean validateWord(int row, int col, String word) {
        // Check user input logic
        return false;
    }

    /**
     * Check if puzzle is complete
     * @return true - all words are correctly filled
     */
    public boolean isComplete() {
        // Check for puzzle completition
        return false;
    }
    
}
