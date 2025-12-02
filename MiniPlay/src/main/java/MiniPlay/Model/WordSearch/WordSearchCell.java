package MiniPlay.Model.WordSearch;

import MiniPlay.Model.GridCell;
import MiniPlay.GUI.WordSearchGUI;

import javax.swing.*;
import java.awt.*;

public class WordSearchCell extends GridCell {

    private WordSearchGame game;
    private WordSearchGUI gui;
    private boolean selected = false;

    public WordSearchCell(int r, int c, Object data) {
        super(r, c, data);

        Object[] arr = (Object[]) data;
        this.game = (WordSearchGame) arr[0];
        this.gui = (WordSearchGUI) arr[1];

        render();
    }

    @Override
    public void handleClick() {

        // Toggle highlighting
        selected = !selected;
        setBackground(selected ? Color.YELLOW : null);

        // Register with game logic
        game.toggleSelect(row, col);

        // Check if word is completed
        String found = game.checkForCompletedWord();

        if (found != null) {
            // Refresh sidebar list (cross out word)
            gui.updateWordList();
        }

        render();
    }

    @Override
    public void render() {
        this.removeAll();

        JLabel label = new JLabel(String.valueOf(game.getLetter(row, col)), SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        this.add(label);

        this.revalidate();
        this.repaint();
    }
}