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

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental: rentals) {
            double thisAmount = getRentalPrice(rental);
            frequentRenterPoints += getFrequenterPoints(rental);
            result.append(statementLine(rental, thisAmount));
            totalAmount += thisAmount;
        }
        result.append(footerLines(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private String footerLines(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points";
    }

    private String statementLine(Rental rental, double rentalPrice) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rentalPrice + "\n";
    }

    private int getFrequenterPoints(Rental rental) {
        if ((rental.getMovie().getPriceCode() == NewRelease.PRICE_CODE) && rental.getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }

    private double getRentalPrice(Rental rental) {
        double price = 0;
        switch (rental.getMovie().getPriceCode()) {
            case RegularMovie.PRICE_CODE -> {
                price += 2;
                if (rental.getDaysRented() > 2)
                    price += (rental.getDaysRented() - 2) * 1.5;
            }
            case NewRelease.PRICE_CODE -> price += rental.getDaysRented() * 3;
            case ChildrensMovie.PRICE_CODE -> {
                price += 1.5;
                if (rental.getDaysRented() > 3)
                    price += (rental.getDaysRented() - 3) * 1.5;
            }
        }
        return price;
    }

}
