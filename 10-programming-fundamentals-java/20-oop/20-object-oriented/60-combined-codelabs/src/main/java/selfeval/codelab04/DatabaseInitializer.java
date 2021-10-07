package selfeval.codelab04;

import selfeval.codelab04.domain.Customer;
import selfeval.codelab04.domain.Movie;

import java.time.LocalDate;
import java.util.List;

public class DatabaseInitializer {
    public static void populateMoviesDB(List<Movie> movies) {
        movies.addAll(List.of(
                new Movie("The Shining", "Kubrick", Movie.Genre.HORROR, Movie.Status.OLDER_MOVIE),
                new Movie("Dune", "Villeneuve", Movie.Genre.SCI_FI, Movie.Status.ONE_DAY_MOVIE),
                new Movie("The Matrix", "Wachowski", Movie.Genre.SCI_FI, Movie.Status.TRENDING_MOVIE),
                new Movie("Borat", "Cohen", Movie.Genre.COMEDY, Movie.Status.OLDER_MOVIE),
                new Movie("Wulpse Woonboten", "Romain", Movie.Genre.XXX, Movie.Status.ONE_DAY_MOVIE)
        ));
    }

    public static void populateCustomerDB(List<Customer> customers) {
        customers.add(new Customer("Klaas Devits", LocalDate.of(1993, 4, 21),
                "klaas.devits@gmail.com", false));
    }
}
