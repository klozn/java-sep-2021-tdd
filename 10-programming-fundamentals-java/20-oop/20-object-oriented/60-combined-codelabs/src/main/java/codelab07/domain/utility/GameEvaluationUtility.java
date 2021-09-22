package codelab07.domain.utility;

import codelab07.domain.Disk;
import codelab07.domain.grid.Grid;
import codelab07.domain.grid.GridArea;

import java.util.Arrays;

public class GameEvaluationUtility {

    public static boolean isGameWon(Grid grid) {
        GridArea[][] gridAreas = grid.getGridAreas();
        if (anyRowHasFourDisksAdjacent(gridAreas)) {
            return true;
        }
        if (anyColHasFourDisksAdjacent(gridAreas)) {
            return true;
        }
        return anyDiagonalLineHasFourDisksAdjacent(gridAreas);
    }

    private static boolean anyRowHasFourDisksAdjacent(GridArea[][] gridAreas) {
        return anyRowOrColHasFourDisksAdjacent(gridAreas, true);
    }

    private static boolean anyColHasFourDisksAdjacent(GridArea[][] gridAreas) {
        return anyRowOrColHasFourDisksAdjacent(gridAreas, false);
    }

    private static boolean anyRowOrColHasFourDisksAdjacent(GridArea[][] gridAreas, boolean forRow) {
        boolean foundFour = false;
        int maxIndex = forRow ? Grid.NR_OF_ROWS - 1 : Grid.NR_OF_COLS - 1;

        for (int index = maxIndex; !foundFour && index >= 0; index--) {
            int adjacentCount = 1;
            GridArea[] areas = getGridAreas(index, gridAreas, forRow);
            Disk[] disks = getDisksFrom(areas);

            for (int i = 0; i < disks.length - 1; i++) {
                if (disks[i].equals(disks[i + 1])) {
                    adjacentCount++;
                } else {
                    adjacentCount = 1;
                }
            }
            foundFour = adjacentCount >= 4;
        }
        return foundFour;
    }

    private static GridArea[] getGridAreas(int index, GridArea[][] gridAreas, boolean forRow) {
        if (forRow) {
            return gridAreas[index];
        } else {
            GridArea[] areas = new GridArea[Grid.NR_OF_ROWS];
            for (int i = 0; i < Grid.NR_OF_ROWS; i++) {
                areas[i] = gridAreas[i][index];
            }
            return areas;
        }
    }

    private static Disk[] getDisksFrom(GridArea[] gridAreas) {
        Disk[] disks = new Disk[countDisks(gridAreas)];
        int index = 0;
        for (GridArea gridArea : gridAreas) {
            if (gridArea.hasDisk()) {
                disks[index++] = gridArea.getDisk();
            }
        }
        return disks;
    }

    private static int countDisks(GridArea[] gridAreas) {
        return (int) Arrays.stream(gridAreas)
                .filter(GridArea::hasDisk)
                .count();
    }

    private static boolean anyDiagonalLineHasFourDisksAdjacent(GridArea[][] gridAreas) {
        return false;
    }

}
