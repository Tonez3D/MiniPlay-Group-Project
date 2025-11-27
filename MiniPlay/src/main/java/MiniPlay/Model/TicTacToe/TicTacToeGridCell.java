package MiniPlay.Model.TicTacToe;

import MiniPlay.GUI.TicTacToeGUI;
import MiniPlay.Model.GridCell;
import MiniPlay.Model.GameManager;

import javax.swing.*;
import java.awt.*;

public class TicTacToeGridCell extends GridCell {

    private TicTacToeGame game;
    private GameManager manager;
    private TicTacToeGUI gui;

    public TicTacToeGridCell(int r, int c, Object data) {
        super(r, c, data);

        Object[] arr = (Object[]) data;
        this.game = (TicTacToeGame) arr[0];
        this.manager = (GameManager) arr[1];
        this.gui = (TicTacToeGUI) arr[2];

        render();
    }

    @Override
    public void handleClick() {
        if (game.isGameOver())
            return;

        boolean moved = game.makeMove(row, col);
        if (!moved)
            return;

        // If game ended after this move, handle winner/draw
        if (game.isGameOver()) {
            if (game.getWinner() != ' ') {
                int[][] winCells = game.getWinningCells();
                gui.animateWin(winCells);
            }

            String msg = (game.getWinner() != ' ')
                    ? ("Player " + game.getWinner() + " wins!")
                    : "It's a draw!";

            int option = JOptionPane.showConfirmDialog(
                    this,
                    msg + "\n\nPlay again?",
                    "Game Over",
                    JOptionPane.YES_NO_OPTION
            );

            if (option == JOptionPane.YES_OPTION) {
                game.reset();
                gui.refreshBoard();
            } else {
                manager.showMainMenu();
            }
        }

        render();
    }

    @Override
    public void render() {
        this.removeAll();
        JLabel label = new JLabel(String.valueOf(game.getCell(row, col)), SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 26));
        this.add(label);
        this.revalidate();
        this.repaint();
    }
}