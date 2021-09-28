package advanced.codelab01;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private final String name;
    private boolean loyal;
    private final Set<Grocery> groceries = new HashSet<>();

    public Customer(String name) {
        this.name = name;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public boolean addGrocery(Grocery grocery) {
        return groceries.add(grocery);
    }

    public Set<Grocery> getGroceries() {
        return groceries;
    }
}
