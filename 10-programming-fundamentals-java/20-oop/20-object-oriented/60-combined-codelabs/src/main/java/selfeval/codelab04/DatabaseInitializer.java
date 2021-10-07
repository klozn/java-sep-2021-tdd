package selfeval.codelab04;

import selfeval.codelab04.domain.Customer;
import selfeval.codelab04.domain.Genre;
import selfeval.codelab04.domain.Movie;
import selfeval.codelab04.domain.MovieStatus;

import java.time.LocalDate;

public class DatabaseInitializer {
    public static void populate(Movie[] movies) {
        movies[0] = new Movie("The Shining", "Kubrick", Genre.HORROR, MovieStatus.OLDER_MOVIE);
        movies[1] = new Movie("Dune", "Villeneuve", Genre.SCI_FI, MovieStatus.ONE_DAY_MOVIE);
        movies[2] = new Movie("The Matrix", "Wachowski", Genre.SCI_FI, MovieStatus.TRENDING_MOVIE);
        movies[3] = new Movie("Borat", "Cohen", Genre.COMEDY, MovieStatus.OLDER_MOVIE);
    }

    public static void populate(Customer[] customers) {
        customers[0] = new Customer("Klaas Devits", LocalDate.of(1993, 4, 21),
                "klaas.devits@gmail.com", false);
    }
}
