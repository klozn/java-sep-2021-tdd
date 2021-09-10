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

    private void placeShip(Ship ship) {
        Random random = new Random();
        int startingPositionX;
        int startingPositionY;
        boolean horizontalPlacement;

        do {
            startingPositionX = random.nextInt(NUMBER_OF_ROWS);
            startingPositionY = random.nextInt(NUMBER_0F_COLUMNS);
            horizontalPlacement = random.nextBoolean();
        } while (checkAvailability(startingPositionX, startingPositionY, horizontalPlacement, ship));

        if (horizontalPlacement) {
            for (int i = startingPositionX; i < ship.getSize(); i++) {
                grid[i][startingPositionY].addShipPart(ship);
            }
        } else {
            for (int j = startingPositionY; j < ship.getSize(); j++) {
                grid[startingPositionX][j].addShipPart(ship);
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
                // TODO: if it is surrounded by ship parts: return false
            }
        } else {
            if (yPos + ship.getSize() > NUMBER_0F_COLUMNS - 1) {
                return false;
            }
            for (int j = yPos; j < ship.getSize(); j++) {
                if (grid[xPos][j].hasShipPart()) {
                    return false;
                }
                // TODO: if it is surrounded by ship parts: return false
            }
        }
        return true;
    }

    public void updateGameStatus() {
        boolean shipPartsFound = false;
        for (int i = 0; i < NUMBER_OF_ROWS && !shipPartsFound; i++) {
            for (int j = 0; j < NUMBER_0F_COLUMNS && !shipPartsFound; j++) {
                if (grid[i][j].hasShipPart() && !grid[i][j].isFiredAt()) {
                    shipPartsFound = true;
                }
            }
        }
        gameOver = !shipPartsFound;
    }




}
