package codelab09;

import java.util.Arrays;
import java.util.Random;

public class BattleShipGameService {
    private GridArea[][] grid;
    private Ship[] ships;
    private boolean gameOver;

    public BattleShipGameService() {
        gameOver = false;
        ships = BattleShipUtility.initializeShips();
        grid = BattleShipUtility.initializeGrid();
        BattleShipUtility.placeShipsOntoGrid(ships, grid);
    }

    public Ship[] getShips() {
        return ships;
    }

    public void updateGameStatus() {
        gameOver = Arrays.stream(getShips()).allMatch(Ship::isSunk);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String bomb(int x, int y) {
        return grid[x][y].bomb();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (GridArea[] row: grid) {
            for (GridArea gridArea: row) {
                sb.append(gridArea.printValue());
                sb.append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
