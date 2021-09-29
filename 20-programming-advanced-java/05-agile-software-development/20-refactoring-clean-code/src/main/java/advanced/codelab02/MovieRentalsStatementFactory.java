package advanced.codelab02;

public class MovieRentalsStatementFactory implements CustomerStatementFactory {

    @Override
    public Statement createStatementFor(Customer customer) {
        Statement statement = new Statement();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        statement.setHeader("Rental Record for " + customer.getName() + "\n");

        for (Rental rental : customer.getRentals()) {
            double thisAmount = MovieRentalUtil.calcRentalPrice(rental);
            frequentRenterPoints += MovieRentalUtil.getFrequenterPoints(rental);
            statement.addStatementLine("\t" + movieTitle(rental) + "\t" + thisAmount + "\n");
            totalAmount += thisAmount;
        }

        customer.gainPoints(frequentRenterPoints);
        statement.setFooter("Amount owed is " + totalAmount
                + "\nYou earned " + frequentRenterPoints + " frequent renter points"
                + "\nYou now have " + customer.totalPoints() + " points in total.");

        return statement;
    }

    private String movieTitle(Rental rental) {
        return rental.getMovie().getTitle();
    }
}
