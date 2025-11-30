/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.Model.TicTacToe;

public class TicTacToeGame {

    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private boolean gameOver = false;
    private char winner = ' ';

    public TicTacToeGame() {
        reset();
    }

    public char getCell(int r, int c) {
        return board[r][c];
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean makeMove(int r, int c) {
        if (gameOver) return false;
        if (board[r][c] != ' ') return false;

        board[r][c] = currentPlayer;

        if (checkWin(currentPlayer)) {
            winner = currentPlayer;
            gameOver = true;
        } else if (checkDraw()) {
            gameOver = true;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    private boolean checkDraw() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[r][c] == ' ')
                    return false;
        return true;
    }

    private boolean checkWin(char p) {
        // Rows/cols
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }
        // Diagonals
        return (board[0][0] == p && board[1][1] == p && board[2][2] == p) ||
               (board[0][2] == p && board[1][1] == p && board[2][0] == p);
    }

    // Return the 3 winning cells as { {r1,c1}, {r2,c2}, {r3,c3} },
    // or null if there is no winner (draw or game not over).
    public int[][] getWinningCells() {
        if (winner == ' ')
            return null;

        // Rows
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == winner && board[r][1] == winner && board[r][2] == winner) {
                return new int[][] { {r,0}, {r,1}, {r,2} };
            }
        }
        // Columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == winner && board[1][c] == winner && board[2][c] == winner) {
                return new int[][] { {0,c}, {1,c}, {2,c} };
            }
        }
        // Main diagonal
        if (board[0][0] == winner && board[1][1] == winner && board[2][2] == winner) {
            return new int[][] { {0,0}, {1,1}, {2,2} };
        }
        // Anti-diagonal
        if (board[0][2] == winner && board[1][1] == winner && board[2][0] == winner) {
            return new int[][] { {0,2}, {1,1}, {2,0} };
        }

        return null;
    }

    public void reset() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
        currentPlayer = 'X';
        winner = ' ';
        gameOver = false;
    }
}