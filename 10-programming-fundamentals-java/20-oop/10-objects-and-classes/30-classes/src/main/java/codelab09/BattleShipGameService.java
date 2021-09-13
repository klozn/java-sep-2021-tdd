package codelab09;

import java.util.Arrays;
import java.util.Random;

public class BattleShipGameService {

    public final static int NUMBER_OF_ROWS = 10;
    public final static int NUMBER_0F_COLUMNS = 10;

    private final GridArea[][] grid = new GridArea[NUMBER_OF_ROWS][NUMBER_0F_COLUMNS];
    private final Ship[] ships = new Ship[5];
    private boolean gameOver;

    public BattleShipGameService() {
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
            available = checkAvailability(startingPositionX, startingPositionY, horizontalPlacement, ship.getSize());
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

    private boolean checkAvailability(int xPos, int yPos, boolean horizontalPlacement, int shipSize) {
        if (outsideOfGrid(xPos, yPos, horizontalPlacement, shipSize)) return false;
        if (gridAreasTaken(xPos, yPos, horizontalPlacement, shipSize)) return false;
        if (surroundingGridAreasTaken(xPos, yPos, horizontalPlacement, shipSize)) return false;
        return true;
    }

    private boolean outsideOfGrid(int xPos, int yPos, boolean horizontalPlacement, int shipSize) {
        if (horizontalPlacement) {
            if (xPos + shipSize > NUMBER_OF_ROWS - 1) {
                return true;
            }
        } else {
            if (yPos + shipSize > NUMBER_0F_COLUMNS - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean gridAreasTaken(int xPos, int yPos, boolean horizontalPlacement, int shipSize) {
        if (horizontalPlacement) {
            for (int i = xPos; i < xPos + shipSize; i++) {
                if (grid[i][yPos].hasShipPart()) {
                    return true;
                }
            }
        } else {
            for (int j = yPos; j < yPos + shipSize; j++) {
                if (grid[xPos][j].hasShipPart()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean surroundingGridAreasTaken(int xPos, int yPos, boolean horizontalPlacement, int shipSize) {
        if (horizontalPlacement) {
            for (int i = xPos; i < xPos + shipSize; i++) {
                if (i == xPos) {
                    if (i > 0 && grid[i - 1][yPos].hasShipPart()) {
                        return true;
                    }
                }
                if (yPos > 0 && grid[i][yPos - 1].hasShipPart()) {
                    return true;
                }
                if (yPos < NUMBER_0F_COLUMNS - 1 && grid[i][yPos + 1].hasShipPart()) {
                    return true;
                }
                if (i == xPos + shipSize) {
                    if (i < NUMBER_OF_ROWS - 1 && grid[i + 1][yPos].hasShipPart()) {
                        return true;
                    }
                }
            }
        } else {
            for (int i = yPos; i < yPos + shipSize; i++) {
                if (i == yPos) {
                    if (i > 0 && grid[xPos][i - 1].hasShipPart()) {
                        return true;
                    }
                }
                if (xPos > 0 && grid[xPos - 1][i].hasShipPart()) {
                    return true;
                }
                if (xPos < NUMBER_OF_ROWS - 1 && grid[xPos + 1][i].hasShipPart()) {
                    return true;
                }
                if (i == yPos + shipSize) {
                    if (i < NUMBER_OF_ROWS - 1 && grid[xPos][i + 1].hasShipPart()) {
                        return true;
                    }
                }
            }
        }
        return false;
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
