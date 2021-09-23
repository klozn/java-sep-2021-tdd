package grasp.creator;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int BOARD_DIMENSION = 10;

    private List<Coordinate> bombs;
    private List<Coordinate> hits = new ArrayList<>();

    public Board(List<Coordinate> bombs) {
        this.bombs = bombs;
    }

    public void hit(Coordinate coordinate) {
        hits.add(coordinate);
    }

    public boolean isDead() {
        for(Coordinate hit: hits) {
            if(bombs.contains(hit)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasWon() {
        return (100 - bombs.size()) == hits.size();
    }

    @Override
    public String toString() {
        String result = "";
        for (int x = 0; x < BOARD_DIMENSION; x++) {
            for (int y = 0; y < BOARD_DIMENSION; y++) {
                result += "[" + calculateSymbol(x, y) + "]";
            }
            result += "\n";
        }
        return result;
    }

    private char calculateSymbol(int x, int y) {
        if (hits.contains(new Coordinate(x, y)) && bombs.contains(new Coordinate(x, y))) {
            return 'X';
        }

        if (hits.contains(new Coordinate(x, y))) {
            return Character.forDigit(calculateNumberOfNeighbouringBombs(x, y), 10);
        }

        return ' ';
    }

    private int calculateNumberOfNeighbouringBombs(int x, int y) {
        List<Coordinate> neighbouringCoordinates = new Coordinate(x, y).getNeighbouringCoordinates();
        int numberOfBombs = 0;
        for(Coordinate neighbour: neighbouringCoordinates) {
            if(bombs.contains(neighbour)) {
                numberOfBombs++;
            }
        }
        return numberOfBombs;
    }

}
