/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public abstract class GridCell extends JPanel implements MouseListener {

    protected int row;
    protected int col;
    protected Object game;   // NEW

    public GridCell(int r, int c, Object gameObj) {
        this.row = r;
        this.col = c;
        this.game = gameObj;

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