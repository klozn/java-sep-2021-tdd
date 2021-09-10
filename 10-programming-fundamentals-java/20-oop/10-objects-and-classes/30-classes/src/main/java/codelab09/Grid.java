package codelab09;

import java.util.Arrays;
import java.util.Random;

public class Grid {

    public final static int NUMBER_OF_ROWS = 10;
    public final static int NUMBER_0F_COLUMNS = 10;

    private GridArea[][] grid = new GridArea[NUMBER_OF_ROWS][NUMBER_0F_COLUMNS];
    private Ship[] ships = new Ship[5];
    private boolean gameOver;

    public Grid() {
        gameOver = false;
        initializeShips();
        initializeGrid();
    }

    private void initializeShips() {
        ships[0] = new Ship(5, "Carrier");
        ships[1] = new Ship(4, "Battleship");
        ships[2] = new Ship(3, "Destroyer");
        ships[3] = new Ship(3, "Submarine");
        ships[4] = new Ship(2, "Patrol Boat");
    }

    private void initializeGrid() {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_0F_COLUMNS; j++) {
                grid[i][j] = new GridArea(i, j);
            }
        }
        for (Ship s: ships) {
            placeShip(s);
        }
    }

    public Ship[] getShips() {
        return ships;
    }

    private void placeShip(Ship ship) {
        Random random = new Random();
        int startingPositionX;
        int startingPositionY;
        boolean horizontalPlacement;

        boolean available;
        do {
            startingPositionX = random.nextInt(NUMBER_OF_ROWS);
            startingPositionY = random.nextInt(NUMBER_0F_COLUMNS);
            horizontalPlacement = random.nextBoolean();
            available = checkAvailability(startingPositionX, startingPositionY, horizontalPlacement, ship);
        } while (!available);

        if (horizontalPlacement) {
            for (int i = startingPositionX, j = 0; j < ship.getSize(); i++, j++) {
                grid[i][startingPositionY].addShipPart(ship);
            }
        } else {
            for (int i = startingPositionY, j = 0; j < ship.getSize(); i++, j++) {
                grid[startingPositionX][i].addShipPart(ship);
            }
        }
    }

    private boolean checkAvailability(int xPos, int yPos, boolean horizontalPlacement, Ship ship) {

        if (grid[xPos][yPos].hasShipPart()) {
            return false;
        }
        if (horizontalPlacement) {
            if (xPos + ship.getSize() > NUMBER_OF_ROWS - 1) {
                return false;
            }
            for (int i = xPos; i < ship.getSize(); i++) {
                if (grid[i][yPos].hasShipPart()) {
                    return false;
                }
                // If it is surrounded by ship parts: return false
                try {
                    if (i == xPos && grid[i-1][yPos].hasShipPart()){
                        return false;
                    }
                    if (i == xPos + ship.getSize() && grid[i+1][yPos].hasShipPart()) {
                        return false;
                    }
                    if (grid[i][yPos - 1].hasShipPart() || grid[i][yPos + 1].hasShipPart()) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        } else {
            if (yPos + ship.getSize() > NUMBER_0F_COLUMNS - 1) {
                return false;
            }
            for (int j = yPos; j < ship.getSize(); j++) {
                if (grid[xPos][j].hasShipPart()) {
                    return false;
                }
                // If it is surrounded by ship parts: return false
                try {
                    if (j == yPos && grid[xPos][j-1].hasShipPart()){
                        return false;
                    }
                    if (j == yPos + ship.getSize() && grid[xPos][j+1].hasShipPart()) {
                        return false;
                    }
                    if (grid[xPos - 1][j].hasShipPart() || grid[xPos + 1][j].hasShipPart()) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return true;
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
