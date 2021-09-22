package codelab07.domain;

import codelab07.domain.grid.Grid;

import java.util.Arrays;

public class Player {
    private final int id;
    private final String name;
    private final char diskDisplayValue;
    private final Disk[] disks = new Disk[Grid.NR_OF_ROWS * Grid.NR_OF_COLS / 2];

    public Player(int id, String name, char diskDisplayValue) {
        this.id = id;
        this.name = name;
        this.diskDisplayValue = diskDisplayValue;
        fillDiskArray(diskDisplayValue);
    }

    public String getName() {
        return name;
    }

    public char getDiskDisplayValue() {
        return diskDisplayValue;
    }

    private void fillDiskArray(char diskDisplayValue) {
        for (int i = 0; i < disks.length; i++) {
            disks[i] = new Disk(diskDisplayValue);
        }
    }

    public Disk getNextDisk() {
        int index = 0;
        while (index < disks.length && disks[index].isDropped()) {
            index++;
        }
        return disks[index];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player ").append(id);
        sb.append(": ").append(name).append(' ');
        sb.append('(').append(diskDisplayValue).append(')');
        return sb.toString();
    }
}
