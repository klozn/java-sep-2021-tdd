package advanced.codelab02;

public class MovieRentalsStatementFactory implements CustomerStatementFactory {

    @Override
    public Statement createStatementFor(Customer customer) {
        Statement statement = new Statement();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        statement.setHeaderLines("Rental Record for " + customer.getName() + "\n");

        for (Rental rental : customer.getRentals()) {
            double thisAmount = MovieRentalUtil.calcRentalPrice(rental);
            frequentRenterPoints += MovieRentalUtil.getFrequenterPoints(rental);
            statement.addStatementLine(statementLine(rental, thisAmount));
            totalAmount += thisAmount;
        }

        statement.setFooterLines("Amount owed is " + totalAmount
                + "\nYou earned " + frequentRenterPoints + " frequent renter points");
        return statement;
    }

    private String statementLine(Rental rental, double rentalPrice) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rentalPrice + "\n";
    }
}
