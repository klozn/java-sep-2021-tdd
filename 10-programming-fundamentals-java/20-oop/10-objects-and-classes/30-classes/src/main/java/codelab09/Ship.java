package codelab09;

import java.util.Arrays;

public class Ship {
    private int size;
    private String name;
    private GridArea[] gridAreas;
    private boolean sunk;

    public Ship(int size, String name) {
        this.size = size;
        this.name = name;
        gridAreas = new GridArea[size];
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public boolean isSunk() {
        return Arrays.stream(gridAreas).allMatch(GridArea::isFiredAt);
    }

    public void addGridArea(GridArea gridArea) {
        boolean added = false;
        for (int i = 0; i < size && !added; i++) {
            if (gridAreas[i] == null) {
                gridAreas[i] = gridArea;
                added = true;
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ship{");
        sb.append("size=").append(size);
        sb.append(", name='").append(name).append('\'');
        sb.append(", gridAreas=").append(Arrays.toString(gridAreas));
        sb.append(", sunk=").append(sunk);
        sb.append('}');
        return sb.toString();
    }
}
