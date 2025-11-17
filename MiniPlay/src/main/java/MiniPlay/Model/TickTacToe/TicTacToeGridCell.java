package MiniPlay.Model.TickTacToe;

import MiniPlay.Model.GridCell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToeGridCell extends GridCell {
    public TicTacToeGridCell(int width, int height) {
        //super(width, height);
        this.setWidth(width);
        this.setHeight(height);
        //this.width = width;
        //this.height = height;
        this.color = Color.GRAY;

        JLabel label = new JLabel("Hello");
        this.add(label);
        addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }

    @Override
    public JComponent createComp() {
        JPanel panel = new JPanel();
        panel.setSize(1, 1);
        //panel.setBackground(color);
        JLabel label = new JLabel("HII");
        panel.add(label);
        //panel;
        panel.setVisible(true);
        return panel;

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
