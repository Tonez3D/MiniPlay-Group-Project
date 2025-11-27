package MiniPlay.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public abstract class GridCell extends JPanel implements MouseListener {

    protected int row;
    protected int col;

    public GridCell(int r, int c) {
        this.row = r;
        this.col = c;

        setPreferredSize(new Dimension(40, 40));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addMouseListener(this);
    }

    public abstract void handleClick();
    public abstract void render();

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        handleClick();
        render();
    }

    @Override public void mousePressed(java.awt.event.MouseEvent e) {}
    @Override public void mouseReleased(java.awt.event.MouseEvent e) {}
    @Override public void mouseEntered(java.awt.event.MouseEvent e) {}
    @Override public void mouseExited(java.awt.event.MouseEvent e) {}
}