package codelab07.domain.grid;

import codelab07.domain.Disk;

public class GridArea {
    private final GridPosition gridPosition;
    private Disk disk;

    public GridArea(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public boolean hasDisk() {
        return this.disk != null;
    }

    public String getDiskValue() {
        return disk.getDisplayValue();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(hasDisk() ? getDiskValue() : ' ');
        sb.append(']');
        return sb.toString();
    }
}
