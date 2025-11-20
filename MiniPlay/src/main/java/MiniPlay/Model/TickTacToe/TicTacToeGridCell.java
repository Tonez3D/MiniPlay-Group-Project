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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(20, 40);
        //panel.setBackground(color);

        JPanel panel_1 = new JPanel();
        panel_1.setSize(40, 30);
        panel_1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        panel.add(panel_1);

        //panel;
        panel.setVisible(true);
        return panel;

    }

    @Override
    public JComponent createComp(Dimension size) {
        JPanel panel = new JPanel();
        panel.setSize(1, 1);
        //panel.setBackground(color);
        JLabel label = new JLabel("HII");
        label.setPreferredSize(size);
        panel.add(label);
        //panel;
        panel.setVisible(true);
        return panel;
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
