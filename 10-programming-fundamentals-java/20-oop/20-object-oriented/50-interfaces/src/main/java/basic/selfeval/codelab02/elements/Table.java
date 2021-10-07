package basic.selfeval.codelab02.elements;

import basic.selfeval.codelab02.Downloadable;

public class Table implements Downloadable {

    private final int rows;
    private final int columns;
    private final String[][] cells;

    public Table(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new String[rows][columns];
    }

    public void insertInCell(int row, int column, String cellData) {
        cells[row][column] = cellData;
    }

    @Override
    public String download() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] row: cells) {
            for (String cell: row) {
                sb.append("[").append(cell).append("]");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
