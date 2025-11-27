package MiniPlay.Model.TicTacToe;

import MiniPlay.Model.GridCell;
import javax.swing.*;
import java.awt.*;

public class TicTacToeGridCell extends GridCell {

    private char value = ' ';

    public TicTacToeGridCell(int r, int c) {
        super(r, c);
        render();
    }

    @Override
    public void handleClick() {
        if (value == ' ')
            value = 'X';
        else if (value == 'X')
            value = 'O';
        else
            value = ' ';
    }

    @Override
    public void render() {
        this.removeAll();
        JLabel label = new JLabel(String.valueOf(value), SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 26));
        this.add(label);

        this.revalidate();
        this.repaint();
    }
}