/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.Model;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    private GridCell[][] cells;

    public Grid(int rows, int cols, Class<? extends GridCell> cellType, Object gameObj) {

        setLayout(new GridLayout(rows, cols));
        cells = new GridCell[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                try {
                    GridCell cell = cellType
                            .getDeclaredConstructor(int.class, int.class, Object.class)
                            .newInstance(r, c, gameObj);


                    cells[r][c] = cell;
                    add(cell);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public GridCell getCell(int r, int c) {
        return cells[r][c];
    }
}