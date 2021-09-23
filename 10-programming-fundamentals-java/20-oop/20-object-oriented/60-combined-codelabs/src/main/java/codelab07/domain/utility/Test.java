package codelab07.domain.utility;

import codelab07.domain.grid.Grid;
import codelab07.domain.grid.GridArea;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Grid grid = new Grid();

        for (GridArea[] gridAreas : GameEvaluationUtility.getAllDiagonalLines(grid.getGridAreas())) {
            System.out.println(Arrays.toString(gridAreas));
        }
    }
}
