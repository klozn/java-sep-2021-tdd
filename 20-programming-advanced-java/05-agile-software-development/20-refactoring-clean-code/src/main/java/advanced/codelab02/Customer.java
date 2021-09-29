package advanced.codelab02;

import advanced.codelab02.movies.ChildrensMovie;
import advanced.codelab02.movies.NewRelease;
import advanced.codelab02.movies.RegularMovie;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals;

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




}
