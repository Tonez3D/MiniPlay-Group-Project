package MiniPlay.Model;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    private GridCell[][] cells;

    public Grid(int rows, int cols, Class<? extends GridCell> cellType) {
        this.setLayout(new GridLayout(rows, cols));
        cells = new GridCell[rows][cols];

        // Create all cells dynamically
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                try {
                    GridCell cell = cellType
                            .getDeclaredConstructor(int.class, int.class)
                            .newInstance(r, c);

                    cells[r][c] = cell;
                    this.add(cell);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public GridCell getCell(int r, int c) {
        return cells[r][c];
    }
}