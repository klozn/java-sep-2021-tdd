package codelab09;

import java.util.Random;

public class BattleShipUtility {
    public final static int NUMBER_OF_ROWS = 10;
    public final static int NUMBER_0F_COLUMNS = 10;

    static Ship[] initializeShips() {
        return new Ship[] {
            new Ship(5, "Carrier"),
            new Ship(4, "Battleship"),
            new Ship(3, "Destroyer"),
            new Ship(3, "Submarine"),
            new Ship(2, "Patrol Boat")
        };
    }

    static GridArea[][] initializeGrid() {
        GridArea[][] grid = new GridArea[NUMBER_OF_ROWS][NUMBER_0F_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_0F_COLUMNS; j++) {
                grid[i][j] = new GridArea(i, j);
            }
        }
        return grid;
    }

    static void placeShipsOntoGrid(Ship[] ships, GridArea[][] grid) {
        for (Ship s: ships) {
            placeShip(s, grid);
        }
    }

    private static void placeShip(Ship ship, GridArea[][] grid) {
        Random random = new Random();
        int startingPositionX;
        int startingPositionY;
        boolean horizontalPlacement;

        boolean available;
        do {
            startingPositionX = random.nextInt(NUMBER_OF_ROWS);
            startingPositionY = random.nextInt(NUMBER_0F_COLUMNS);
            horizontalPlacement = random.nextBoolean();
            available = checkAvailability(grid, startingPositionX, startingPositionY,
                    horizontalPlacement, ship.getSize());
        } while (!available);

        if (horizontalPlacement) {
            for (int i = startingPositionY, j = 0; j < ship.getSize(); i++, j++) {
                grid[startingPositionX][i].addShipPart(ship);
            }
        } else {
            for (int i = startingPositionX, j = 0; j < ship.getSize(); i++, j++) {
                grid[i][startingPositionY].addShipPart(ship);
            }
        }
    }

    private static  boolean checkAvailability(GridArea[][] grid, int xPos, int yPos,
                                              boolean horizontalPlacement, int shipSize) {
        if (outsideOfGrid(xPos, yPos, horizontalPlacement, shipSize)) return false;
        if (gridAreasTaken(grid, xPos, yPos, horizontalPlacement, shipSize)) return false;
        if (surroundingGridAreasTaken(grid, xPos, yPos, horizontalPlacement, shipSize)) return false;
        return true;
    }

    private static boolean outsideOfGrid(int xPos, int yPos, boolean horizontalPlacement, int shipSize) {
        if (horizontalPlacement) {
            return yPos + shipSize > NUMBER_0F_COLUMNS - 1;
        } else {
            return xPos + shipSize > NUMBER_OF_ROWS - 1;
        }
    }

    private static boolean gridAreasTaken(GridArea[][] grid, int xPos, int yPos,
                                          boolean horizontalPlacement, int shipSize) {
        if (horizontalPlacement) {
            for (int i = yPos; i < yPos + shipSize; i++) {
                if (grid[xPos][i].hasShipPart()) {
                    return true;
                }
            }
        } else {
            for (int i = xPos; i < xPos + shipSize; i++) {
                if (grid[i][yPos].hasShipPart()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean surroundingGridAreasTaken(GridArea[][] grid, int xPos, int yPos,
                                                     boolean horizontalPlacement, int shipSize) {
        if (horizontalPlacement) {
            for (int i = yPos; i <= yPos + shipSize; i++) {
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
                    if (i < NUMBER_0F_COLUMNS - 1 && grid[xPos][i + 1].hasShipPart()) {
                        return true;
                    }
                }
            }
        } else {
            for (int i = xPos; i <= xPos + shipSize; i++) {
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
        }
        return false;
    }
}
