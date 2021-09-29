package advanced.codelab02;

import advanced.codelab02.movies.ChildrensMovie;
import advanced.codelab02.movies.NewRelease;
import advanced.codelab02.movies.RegularMovie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerStatementFactoryTest {
    private final CustomerStatementFactory factory = new MovieRentalsStatementFactory();

    @Test
    void statement_givenCustomerWithOneRentalFor3DaysContainingARegularMovie_thenReturnCorrectResult() {
        Customer customer = createCustomerWithRentals("Becky",
                new Rental[]{
                        new Rental(new RegularMovie("Minority Report"), 3)
                });
        String expectedResult = """
                Rental Record for Becky
                \tMinority Report\t3.5
                Amount owed is 3.5
                You earned 1 frequent renter points""";

        String actualResult = factory.createStatementFor(customer).toString();

        assertEquals(expectedResult, actualResult);
    }

    private Customer createCustomerWithRentals(String customerName, Rental[] rentals) {
        Customer customer = new Customer(customerName);
        for (Rental rental : rentals) {
            customer.addRental(rental);
        }
        return customer;
    }

    @Test
    void statement_givenCustomerWithOneRentalFor3DaysContainingANewReleaseMovie_thenReturnCorrectResult() {
        Customer customer = createCustomerWithRentals("Bruce",
                new Rental[]{
                        new Rental(new NewRelease("A Quiet Place"), 3)
                });
        String expectedResult = """
                Rental Record for Bruce
                \tA Quiet Place\t9.0
                Amount owed is 9.0
                You earned 2 frequent renter points""";

        String actualResult = factory.createStatementFor(customer).toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void statement_givenCustomerWithOneRentalFor3DaysContainingAChildrensMovie_thenReturnCorrectResult() {
        Customer customer = createCustomerWithRentals("Lil' Timmy",
                new Rental[]{
                        new Rental(new ChildrensMovie("Wall-E"), 3)
                });
        String expectedResult = """
                Rental Record for Lil' Timmy
                \tWall-E\t1.5
                Amount owed is 1.5
                You earned 1 frequent renter points""";

        String actualResult = factory.createStatementFor(customer).toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void statement_givenCustomerWithThreeRentalsContainingMoviesWithDifferentPriceCodes_thenReturnCorrectResult() {
        Customer customer = createCustomerWithRentals("Suzzy",
                new Rental[]{
                        new Rental(new ChildrensMovie("Monsters, inc."), 6),
                        new Rental(new NewRelease("Game Night"), 2),
                        new Rental(new RegularMovie("The theory of everything"), 8),
                });
        String expectedResult = """
                Rental Record for Suzzy
                \tMonsters, inc.\t6.0
                \tGame Night\t6.0
                \tThe theory of everything\t11.0
                Amount owed is 23.0
                You earned 4 frequent renter points""";

        String actualResult = factory.createStatementFor(customer).toString();

        assertEquals(expectedResult, actualResult);
    }

}
