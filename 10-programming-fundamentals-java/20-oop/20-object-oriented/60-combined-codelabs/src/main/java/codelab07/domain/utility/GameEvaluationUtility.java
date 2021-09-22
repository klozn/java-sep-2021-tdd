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
        boolean foundFourInRow = false;
        for (int rowIndex = Grid.NR_OF_ROWS - 1; !foundFourInRow && rowIndex >= 0; rowIndex--) {
            int adjacentCount = 1;
            GridArea[] gridRow = gridAreas[rowIndex];
            Disk[] disksInRow = getDisksFrom(gridRow);

            for (int i = 0; i < disksInRow.length - 1; i++) {
                if (disksInRow[i].equals(disksInRow[i + 1])) {
                    adjacentCount++;
                } else {
                    adjacentCount = 1;
                }
            }
            foundFourInRow = adjacentCount >= 4;
        }
        return foundFourInRow;
    }

    private static int countDisks(GridArea[] gridAreas) {
        return (int) Arrays.stream(gridAreas)
                .filter(GridArea::hasDisk)
                .count();
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

    private static boolean anyColHasFourDisksAdjacent(GridArea[][] gridAreas) {
        return false;
    }

    private static boolean anyDiagonalLineHasFourDisksAdjacent(GridArea[][] gridAreas) {
        return false;
    }

}
