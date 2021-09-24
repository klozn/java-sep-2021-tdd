package codelab07.domain.grid;

import java.util.Objects;

public class GridPosition {
    private final int rowIndex;
    private final int colIndex;

    public GridPosition(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridPosition that = (GridPosition) o;
        return rowIndex == that.rowIndex && colIndex == that.colIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, colIndex);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GridPosition{");
        sb.append("rowIndex=").append(rowIndex);
        sb.append(", colIndex=").append(colIndex);
        sb.append('}');
        return sb.toString();
    }
}
