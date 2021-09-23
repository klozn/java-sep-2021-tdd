package codelab07.domain.grid;

import codelab07.domain.Disk;

public class GridArea {
    private final GridPosition gridPosition;
    private Disk disk;

    public GridArea(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public boolean hasDisk() {
        return disk != null;
    }

    public char getDiskDisplayValue() {
        return disk.getDisplayValue();
    }

    public String display() {
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(hasDisk() ? getDiskDisplayValue() : ' ');
        sb.append(']');
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GridArea{");
        sb.append("gridPosition=").append(gridPosition);
        sb.append(", disk=").append(disk);
        sb.append('}');
        return sb.toString();
    }
}
