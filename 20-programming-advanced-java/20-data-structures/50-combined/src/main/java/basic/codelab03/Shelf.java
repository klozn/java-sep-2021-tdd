package basic.codelab03;

import java.util.ArrayDeque;
import java.util.Deque;

public class Shelf {
    private final Deque<Grocery> groceries = new ArrayDeque<>();

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public Grocery getLastGroceryAdded() {
        if (groceries.size() == 0) {
            throw new IllegalStateException("No more groceries on shelf.");
        }
        return groceries.pop();
    }

    public int getNumberOfGroceries() {
        return groceries.size();
    }
}
