package codelab04;

import codelab04.domain.Customer;
import codelab04.domain.Genre;
import codelab04.domain.Movie;

import java.time.LocalDate;

public class DatabaseInitializer {
    public static void populate(Movie[] movies) {
        movies[0] = new Movie("The Shining", "Kubrick", Genre.HORROR, 7.85);
        movies[1] = new Movie("Dune", "Villeneuve", Genre.SCI_FI, 13.45);
        movies[2] = new Movie("The Matrix", "Wachowski", Genre.SCI_FI, 8.95);
        movies[3] = new Movie("Borat", "Cohen", Genre.COMEDY, 4.95);
    }

    public static void populate(Customer[] customers) {
        customers[0] = new Customer("Klaas Devits", LocalDate.of(1993, 4, 21),
                "klaas.devits@gmail.com", false);
    }
}
