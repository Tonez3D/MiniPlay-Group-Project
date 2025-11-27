package MiniPlay.Model.WordSearch;

import MiniPlay.Model.GridCell;
import javax.swing.*;
import java.awt.*;

public class WordSearchCell extends GridCell {

    private char letter;

    public WordSearchCell(int r, int c) {
        super(r, c);
        letter = (char) ('A' + (int)(Math.random() * 26));
        render();
    }

    @Override
    public void handleClick() {
        this.setBackground(Color.YELLOW);
    }

    @Override
    public void render() {
        this.removeAll();
        JLabel label = new JLabel(String.valueOf(letter), SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label);

        this.revalidate();
        this.repaint();
    }
}