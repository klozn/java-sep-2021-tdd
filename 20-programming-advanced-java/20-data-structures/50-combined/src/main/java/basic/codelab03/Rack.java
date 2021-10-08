package basic.codelab03;

import java.util.List;

public class Rack {
    private final List<Shelf> shelves;

    public Rack(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public int getAmountOfShelves() {
        return shelves.size();
    }

    public boolean isEmpty() {
        return shelves.stream().allMatch(shelf -> shelf.getNumberOfGroceries() == 0);
    }

    public void fill(List<Grocery> groceries, int indexOfShelf) {
        assertValidShelfIndex(indexOfShelf);
        Shelf shelf = shelves.get(indexOfShelf);
        groceries.forEach(shelf::addGrocery);
    }

    public Grocery takeGroceryFromShelf(int indexOfShelf) {
        assertValidShelfIndex(indexOfShelf);
        Shelf shelf = shelves.get(indexOfShelf);
        return shelf.getLastGroceryAdded();
    }

    private void assertValidShelfIndex(int indexOfShelf) {
        if (indexOfShelf < 0 || indexOfShelf > getAmountOfShelves() - 1) {
            throw new IllegalArgumentException("Unvalid index for shelves");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Shelf shelf : shelves) {
            sb.append("[");
            sb.append("*".repeat(Math.max(0, shelf.getNumberOfGroceries())));
            sb.append("]");
        }
        return sb.toString();
    }
}
