package advanced.codelab02;

import java.util.Objects;

public class Tile {
    private char letter;
    private int points;

    public Tile(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return letter == tile.letter && points == tile.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, points);
    }

    @Override
    public String toString() {
        return String.format("%d%s", getPoints(), getLetter());
    }
}
