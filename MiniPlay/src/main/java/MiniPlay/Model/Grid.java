/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.Model;

import MiniPlay.Model.TickTacToe.TicTacToeGridCell;

import java.awt.*;
import javax.swing.*;

/**
 * 2D grid used for games like Word Search and Crossword
 */
public class Grid extends JPanel {
   private int grid_rows;
   private int grid_cols;

   private GridBagConstraints constraints;
   private GridBagLayout layout;
   JPanel grid_panel;
   GridCell[] grid;


    /**
     * Construct a grid with specified size
     * @param rows - Number of rows
     * @param cols - Number of columns
     */
    public Grid(int rows, int cols, GridCell cell) {

        this.grid_rows = rows;
        this.grid_cols = cols;

        grid_panel = new JPanel();
        constraints = new  GridBagConstraints();
        layout = new GridBagLayout();
        grid_panel.setLayout(layout);


        for  (int i = 0; i < 9; i++) {

            addObject(cell, i,i);

        }
        //grid_panel.add(cell, grid_layout);
        grid_panel.setVisible(true);
        this.add(grid_panel);
    }

    private void addObject( GridCell cellType, int posx, int posy  ) {
        JComponent component = cellType.getComp();
        constraints.gridx = posx;
        constraints.gridy = posy;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        layout.setConstraints(component, constraints);

        grid_panel.add(component);

    }
    /**
     * Set value at specific cell
     * @param row - Row index
     * @param col - Column index
     * @param value - Character or object to set
     */
    public void setCell(int row, int col, char value) {
        // Setter
    }

    /**
     * Get value at specific cell
     * @param row - Row index
     * @param col - Column index
     * @return Value at the cell
     */
    public char getCell(int row, int col) {
        // Getter
        return ' ';
    }
}
