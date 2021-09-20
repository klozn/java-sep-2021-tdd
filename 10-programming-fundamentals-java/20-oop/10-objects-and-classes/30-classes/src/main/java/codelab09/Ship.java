package codelab09;

import java.util.Arrays;
import java.util.Objects;

public class Ship {
    private final int size;
    private final String name;
    private final GridArea[] gridAreas;

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
        return Arrays.stream(gridAreas).allMatch(GridArea::isBombed);
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
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return size == ship.size && Objects.equals(name, ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
