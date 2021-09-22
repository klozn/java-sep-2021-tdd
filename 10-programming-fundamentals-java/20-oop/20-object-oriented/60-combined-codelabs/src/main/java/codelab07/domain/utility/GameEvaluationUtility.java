package codelab07.domain.utility;

import codelab07.domain.Disk;
import codelab07.domain.grid.Grid;
import codelab07.domain.grid.GridArea;

import java.util.Arrays;

import static codelab07.domain.grid.Grid.*;

public class GameEvaluationUtility {

    private static final int DIAGONAL = (int) Math.sqrt(Math.pow(NR_OF_ROWS, 2) + Math.pow(NR_OF_COLS, 2));
    private static final int EXTRACTION_ARRAY_SIZE = NR_OF_COLS + NR_OF_ROWS - 1;

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
        int maxIndex = forRow ? NR_OF_ROWS - 1 : NR_OF_COLS - 1;

        for (int index = maxIndex; !foundFour && index >= 0; index--) {
            GridArea[] areas = getGridAreasFromRowOrCol(index, gridAreas, forRow);
            Disk[] disks = getDisksFrom(areas);
            foundFour = countAdjacent(disks) >= 4;
        }
        return foundFour;
    }

    private static int countAdjacent(Disk[] disks) {
        int adjacentCount = 1;
        for (int i = 0; i < disks.length - 1; i++) {
            if (disks[i].equals(disks[i + 1])) {
                adjacentCount++;
            } else {
                adjacentCount = 1;
            }
        }
        return adjacentCount;
    }

    private static GridArea[] getGridAreasFromRowOrCol(int index, GridArea[][] gridAreas, boolean forRow) {
        if (forRow) {
            return gridAreas[index];
        } else {
            GridArea[] areas = new GridArea[NR_OF_ROWS];
            for (int i = 0; i < NR_OF_ROWS; i++) {
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

    private static GridArea[][] getDiagonalLines(GridArea[][] gridAreas) {

        GridArea[][] extractionArray = new GridArea[EXTRACTION_ARRAY_SIZE * 2][DIAGONAL];
        for (int diagonalIndex = 0; diagonalIndex < EXTRACTION_ARRAY_SIZE; diagonalIndex++) {
            GridArea[][] extracted = extractDiagonalsTopLeftToBottomRight(gridAreas);
        }
        for (int diagonalIndex = 0; diagonalIndex < EXTRACTION_ARRAY_SIZE; diagonalIndex++) {
            GridArea[][] extracted1 = extractDiagonalsBottomLeftToTopRight(gridAreas);
        }
        return null;
    }

    private static GridArea[][] extractDiagonalsTopLeftToBottomRight(GridArea[][] gridAreas) {
        GridArea[][] extractionArray = new GridArea[NR_OF_COLS + NR_OF_ROWS - 1][DIAGONAL];
        int extRowIndex = 0;
        for (int colIndex = 0; colIndex < NR_OF_COLS; colIndex++, extRowIndex++) {
            for (int rowIndex = 0, counter = colIndex; counter >= 0; rowIndex++, counter--) {
                extractionArray[extRowIndex][colIndex] = gridAreas[rowIndex][counter];
            }
        }
        for (int rowIndex = 1; rowIndex < NR_OF_ROWS - 1; rowIndex++, extRowIndex++) {
            for (int counter = NR_OF_ROWS; counter >= 0; counter--) {
                //extractionArray[rowIndex][colIndex] = gridAreas[rowIndex][counter];
            }
        }
        return extractionArray;
    }

    private static GridArea[][] extractDiagonalsBottomLeftToTopRight(GridArea[][] gridAreas) {
        return null;
    }
}
