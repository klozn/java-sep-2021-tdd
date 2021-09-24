package codelab07.domain.grid;

import java.util.Arrays;

public class Grid {
    public final static int NR_OF_ROWS = 5;
    public final static int NR_OF_COLS = 7;
    private final GridArea[][] gridAreas;

    public Grid() {
        this.gridAreas = initializeGridAreas();
    }

    private GridArea[][] initializeGridAreas() {
        GridArea[][] grid = new GridArea[NR_OF_ROWS][NR_OF_COLS];
        for (int rowIndex = 0; rowIndex < NR_OF_ROWS; rowIndex++) {
            for (int colIndex = 0; colIndex < NR_OF_COLS; colIndex++) {
                grid[rowIndex][colIndex] = new GridArea(new GridPosition(rowIndex, colIndex));
            }
        }
        return grid;
    }

    public GridArea[][] getGridAreas() {
        return gridAreas;
    }

    public void display() {
        final StringBuilder sb = new StringBuilder();
        sb.append("----".repeat(NR_OF_COLS));
        sb.append('\n');
        for (int rowIndex = 0; rowIndex < NR_OF_ROWS; rowIndex++) {
            for (int colIndex = 0; colIndex < NR_OF_COLS; colIndex++) {
                sb.append(gridAreas[rowIndex][colIndex].display());
                sb.append(" ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < NR_OF_COLS; i++) {
            if (i < 10) {
                sb.append(' ').append(i).append("  ");
            } else {
                sb.append(' ').append(i).append(' ');
            }
        }
        sb.append('\n');
        sb.append("----".repeat(NR_OF_COLS));
        System.out.println(sb);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Grid{");
        sb.append("gridAreas=").append(Arrays.toString(gridAreas));
        sb.append('}');
        return sb.toString();
    }
}
