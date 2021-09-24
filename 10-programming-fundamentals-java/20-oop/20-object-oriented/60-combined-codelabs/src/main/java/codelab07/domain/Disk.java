package codelab07.domain;

import codelab07.domain.grid.GridPosition;

import java.util.Objects;

public class Disk {
    private final char displayValue;
    private boolean dropped;
    private GridPosition gridPosition;

    public Disk(char displayValue) {
        this.displayValue = displayValue;
        dropped = false;
        gridPosition = new GridPosition(-1, -1);
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    public char getDisplayValue() {
        return displayValue;
    }

    public boolean isDropped() {
        return dropped;
    }

    public void setDropped(boolean dropped) {
        this.dropped = dropped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disk disk = (Disk) o;
        return displayValue == disk.displayValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayValue);
    }
}
