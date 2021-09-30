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
        throwExceptionIfInvalid(indexOfShelf);
        Shelf shelf = shelves.get(indexOfShelf);
        for (Grocery grocery: groceries) {
            shelf.addGrocery(grocery);
        }
    }

    public Grocery takeGroceryFromShelf(int indexOfShelf) {
        throwExceptionIfInvalid(indexOfShelf);
        Shelf shelf = shelves.get(indexOfShelf);
        return shelf.getLastGroceryAdded();
    }

    private void throwExceptionIfInvalid(int indexOfShelf) {
        if (indexOfShelf < 0 || indexOfShelf > getAmountOfShelves() - 1) {
            throw new IllegalArgumentException("Unvalid index for shelves");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Shelf shelf : shelves) {
            sb.append("[");
            for (int i = 0; i < shelf.getNumberOfGroceries(); i++) {
                sb.append("*");
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
