package basic.codelab03;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private final List<Grocery> groceries = new ArrayList<>();

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public Grocery getLastGroceryAdded() {
        if (groceries.size() == 0) {
            throw new IllegalStateException("No more groceries on shelf.");
        }
        Grocery last = groceries.get(groceries.size() - 1);
        groceries.remove(last);
        return last;
    }

    public int getNumberOfGroceries() {
        return groceries.size();
    }
}
