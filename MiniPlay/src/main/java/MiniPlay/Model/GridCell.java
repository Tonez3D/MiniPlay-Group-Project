package MiniPlay.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public abstract class GridCell extends JPanel implements MouseListener, Cloneable{

    protected Color color;
    //DataPayload payload;
    int width;
    int height;

//    @Override
//    public synchronized void addMouseListener(MouseListener l) {
//        super.addMouseListener(l);
//    }

//    public GridCell(int width, int height, Color color) {
//
//        this.width = width;
//        this.setWidth(width);
//        this.setHeight(height);
//        this.color = color;
//        this.height = height;
//        //this.height = height;
//        this.add(new JLabel("HI"));
//
//    }

//    public GridCell( int width, int height) {
//
//        this.setWidth(width);
//        this.setHeight(height);
//        //this.width = width;
//        //this.height = height;
//        this.color = Color.GRAY;
//        JLabel label = new JLabel("HI");
//        this.add(label);
//        addMouseListener(this);
//
//    }

    public JComponent createComp() {
        JPanel panel = new JPanel();
        panel.setSize(1, 1);
        //panel.setBackground(color);
        JLabel label = new JLabel("HI");
        panel.add(label);
        //panel;
        panel.setVisible(true);
        return panel;

    }
    public Color getColor() {
        return color;
    }

    public void setHeight(int height) {
        //this.height = height;
    }

    public JComponent getComp() {
        System.out.println("TEst");
        return createComp();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("HI");
    }

    public void setWidth(int width) {
        //this.width = width;
    }

    @Override
    public GridCell clone() {
        try {
            GridCell clone = (GridCell) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
