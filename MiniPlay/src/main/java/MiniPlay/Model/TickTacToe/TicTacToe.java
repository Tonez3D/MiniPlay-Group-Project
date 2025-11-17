/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.Model.TickTacToe;

/**
 * Manages the Tic Tac Toe Game
 * Handles the board, moves, and win/draw/lose
 */
public class TicTacToe {
    
    /**
     * Create Tic Tac Toe game
     */
    public TicTacToe() {
        // Create 3x3 board
    }
    
    /**
     * Place a move on the board for player
     *@param row - row index
     *@param col - column index
     *@param symbol - 'X' or 'O'
     *@return true - move is value, otherwise false
     */
    public boolean placeMove(int row, int col, char symbol) {
        // move logic
        return false;
    }
    
    /**
     * Check if player won
     * @return true - if there is a winner
     */
    public boolean checkWin() {
        // Win detection logic
        return false;
    }
    
    /**
     * Check if board is full (draw)
     * @return true - if board is full
     */
    public boolean isDraw() {
        // Detect draw
        return false;
    }
    
}
