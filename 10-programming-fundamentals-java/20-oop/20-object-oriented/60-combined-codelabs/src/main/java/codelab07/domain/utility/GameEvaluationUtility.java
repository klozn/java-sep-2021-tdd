package codelab07.domain.utility;

import codelab07.domain.Disk;
import codelab07.domain.grid.Grid;
import codelab07.domain.grid.GridArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static codelab07.domain.grid.Grid.*;

public class GameEvaluationUtility {
    private static final int DIAGONAL = (int) Math.sqrt(Math.pow(NR_OF_ROWS, 2) + Math.pow(NR_OF_COLS, 2));
    private static final int NR_OF_DIAGONAL_LINES = (NR_OF_COLS + NR_OF_ROWS - 1) * 2;

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
                .filter(Objects::nonNull)
                .filter(GridArea::hasDisk)
                .count();
    }

    private static boolean anyDiagonalLineHasFourDisksAdjacent(GridArea[][] gridAreas) {
        GridArea[][] allDiagonalLines = getAllDiagonalLines(gridAreas);
        GridArea[][] filteredDiagonalLines = filterDiagonalLines(allDiagonalLines);

        boolean foundFour = false;
        for (int index = 0; !foundFour && index < filteredDiagonalLines.length; index++) {
            Disk[] disks = getDisksFrom(filteredDiagonalLines[index]);
            foundFour = countAdjacent(disks) >= 4;
        }
        return foundFour;
    }

    public static GridArea[][] filterDiagonalLines(GridArea[][] diagonalLines) {
        List<GridArea[]> filtered = new ArrayList<>();

        for (GridArea[] diagonalLine : diagonalLines) {
            GridArea[] diagonalLineWithoutNullElements = retrieveNonNulArrayElements(diagonalLine);
            if (countDisks(diagonalLineWithoutNullElements) >= 4) {
                filtered.add(diagonalLineWithoutNullElements);
            }
        }
        return filtered.toArray(GridArea[][]::new);
    }

    private static GridArea[] retrieveNonNulArrayElements(GridArea[] gridAreas) {
        return Arrays.stream(gridAreas)
                .filter(Objects::nonNull)
                .toArray(GridArea[]::new);
    }

    public static GridArea[][] getAllDiagonalLines(GridArea[][] gridAreas) {
        GridArea[][] allDiagonals = new GridArea[NR_OF_DIAGONAL_LINES][DIAGONAL];
        int diagonalIndex = 0;

        GridArea[][] extractionArray = extractDiagonalsTopLeftToBottomRight(gridAreas);
        diagonalIndex = addExtractionsTo(allDiagonals, extractionArray, diagonalIndex);

        extractionArray = extractDiagonalsBottomLeftToTopRight(gridAreas);
        addExtractionsTo(allDiagonals, extractionArray, diagonalIndex);

        return allDiagonals;
    }

    private static int addExtractionsTo(GridArea[][] allDiagonals, GridArea[][] extracted, int diagonalIndex) {
        int newDiagonalIndex = diagonalIndex;
        for (GridArea[] diagonalLine : extracted) {
            allDiagonals[newDiagonalIndex++] = diagonalLine;
        }
        return newDiagonalIndex;
    }


    private static GridArea[][] extractDiagonalsTopLeftToBottomRight(GridArea[][] gridAreas) {
        GridArea[][] extractionArray = new GridArea[NR_OF_DIAGONAL_LINES / 2][DIAGONAL];
        int extRowIndex = 0;

        for (int colIndex = 0; colIndex < NR_OF_COLS; colIndex++, extRowIndex++) {
            GridArea[] diagonal = extractDiagonalTLToBRRowZero(colIndex, gridAreas);
            extractionArray[extRowIndex] = diagonal;
        }
        for (int rowIndex = 1; rowIndex < NR_OF_ROWS; rowIndex++, extRowIndex++) {
            GridArea[] diagonal = extractDiagonalTLToBRLastCol(rowIndex, gridAreas);
            extractionArray[extRowIndex] = diagonal;
        }
        return extractionArray;
    }

    private static GridArea[] extractDiagonalTLToBRRowZero(int colIndex, GridArea[][] gridAreas) {
        GridArea[] diagonal = new GridArea[DIAGONAL];
        int diagonalIndex = 0;

        for (int rowIndex = 0, counter = colIndex; rowIndex < NR_OF_ROWS && counter >= 0; rowIndex++, counter--, diagonalIndex++) {
            diagonal[diagonalIndex] = gridAreas[rowIndex][counter];
        }
        return diagonal;
    }

    private static GridArea[] extractDiagonalTLToBRLastCol(int rowIndex, GridArea[][] gridAreas) {
        GridArea[] diagonal = new GridArea[DIAGONAL];
        int diagonalIndex = 0;

        for (int colIndex = NR_OF_COLS - 1; rowIndex < NR_OF_ROWS; rowIndex++, colIndex--, diagonalIndex++) {
            diagonal[diagonalIndex] = gridAreas[rowIndex][colIndex];
        }
        return diagonal;
    }

    private static GridArea[][] extractDiagonalsBottomLeftToTopRight(GridArea[][] gridAreas) {
        GridArea[][] extractionArray = new GridArea[NR_OF_DIAGONAL_LINES / 2][DIAGONAL];
        int extRowIndex = 0;

        for (int colIndex = 0; colIndex < NR_OF_COLS; colIndex++, extRowIndex++) {
            GridArea[] diagonal = extractDiagonalBLToTRBottomRow(colIndex, gridAreas);
            extractionArray[extRowIndex] = diagonal;
        }
        for (int rowIndex = NR_OF_ROWS - 2; rowIndex >= 0; rowIndex--, extRowIndex++) {
            GridArea[] diagonal = extractDiagonalBLToTRLastCol(rowIndex, gridAreas);
            extractionArray[extRowIndex] = diagonal;
        }
        return extractionArray;
    }

    private static GridArea[] extractDiagonalBLToTRBottomRow(int colIndex, GridArea[][] gridAreas) {
        GridArea[] diagonal = new GridArea[DIAGONAL];
        int diagonalIndex = 0;

        for (int rowIndex = NR_OF_ROWS - 1, counter = colIndex; rowIndex >= 0 && counter >= 0; rowIndex--, counter--, diagonalIndex++) {
            diagonal[diagonalIndex] = gridAreas[rowIndex][counter];
        }
        return diagonal;
    }

    private static GridArea[] extractDiagonalBLToTRLastCol(int rowIndex, GridArea[][] gridAreas) {
        GridArea[] diagonal = new GridArea[DIAGONAL];
        int diagonalIndex = 0;

        for (int colIndex = NR_OF_COLS - 2; rowIndex >= 0 && colIndex >= 0; rowIndex--, colIndex--, diagonalIndex++) {
            diagonal[diagonalIndex] = gridAreas[rowIndex][colIndex];
        }
        return diagonal;
    }
}
