package advanced.codelab02;

import advanced.codelab02.movies.ChildrensMovie;
import advanced.codelab02.movies.NewRelease;
import advanced.codelab02.movies.RegularMovie;

public class MovieRentalsStatementFactory implements CustomerStatementFactory {
    @Override
    public Statement createStatementFor(Customer customer) {
        Statement statement = new Statement();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        statement.setHeaderLines("Rental Record for " + customer.getName() + "\n");

        for (Rental rental: customer.getRentals()) {
            double thisAmount = getRentalPrice(rental);
            frequentRenterPoints += getFrequenterPoints(rental);
            statement.addStatementLine(statementLine(rental, thisAmount));
            totalAmount += thisAmount;
        }

        statement.setFooterLines("Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints +
                " frequent renter points");
        return statement;
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
