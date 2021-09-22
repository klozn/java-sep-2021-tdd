package grasp.creator;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public List<Coordinate> getNeighbouringCoordinates() {
        return asList(
                new Coordinate(x - 1, y - 1),
                new Coordinate(x - 1, y),
                new Coordinate(x - 1, y + 1),
                new Coordinate(x, y - 1),
                new Coordinate(x, y + 1),
                new Coordinate(x + 1, y - 1),
                new Coordinate(x + 1, y),
                new Coordinate(x + 1, y + 1)
        );
    }
}
