package advanced.codelab02;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals;
    private int frequentRenterPoints;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<>();
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public void gainPoints(int frequentRenterPoints) {
        if (frequentRenterPoints < 0) {
            throw new IllegalArgumentException("No negative values");
        }
        this.frequentRenterPoints += frequentRenterPoints;
    }

    public int totalPoints() {
        return frequentRenterPoints;
    }

}
