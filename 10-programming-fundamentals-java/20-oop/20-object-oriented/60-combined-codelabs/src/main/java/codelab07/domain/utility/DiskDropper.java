package codelab07.domain.utility;

import codelab07.domain.Disk;
import codelab07.domain.grid.Grid;
import codelab07.domain.grid.GridArea;

public class DiskDropper {
    public static boolean drop(Disk disk, int colIndex, Grid grid) {
        int rowIndex = getRowIndex(colIndex, grid);
        GridArea gridArea = grid.getGridAreas()[rowIndex][colIndex];
        if (gridAreaHasDisk(gridArea)) {
            System.out.println("Column " + colIndex + " is full");
            return false;
        } else {
            gridArea.setDisk(disk);
            disk.setDropped(true);
            disk.setGridPosition(gridArea.getGridPosition());
            return true;
        }
    }

    private static int getRowIndex(int colIndex, Grid grid) {
        int index = 0;
        GridArea[][] gridAreas = grid.getGridAreas();
        while (index < Grid.NR_OF_ROWS - 1 && !gridAreaHasDisk(gridAreas[index + 1][colIndex])) {
            index++;
        }
        return index;
    }

    private static boolean gridAreaHasDisk(GridArea gridArea) {
        return gridArea.hasDisk();
    }
}
