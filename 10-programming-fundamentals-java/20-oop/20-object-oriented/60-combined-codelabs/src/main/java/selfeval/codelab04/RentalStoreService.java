package selfeval.codelab04;

import selfeval.codelab04.domain.Customer;
import selfeval.codelab04.domain.Movie;
import selfeval.codelab04.domain.Rental;

import java.time.LocalDate;
import java.util.*;

public class RentalStoreService {
    private final List<Customer> customers;
    private final List<Movie> movies;
    private final List<Rental> rentals;

    public RentalStoreService() {
        customers = new ArrayList<>();
        movies = new ArrayList<>();
        rentals = new ArrayList<>();
        DatabaseInitializer.populateMoviesDB(movies);
        DatabaseInitializer.populateCustomerDB(customers);
    }

    public void addNewCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("No customer added to database.");
        } else {
            customers.add(customer);
        }
    }

    public void addNewMovie(Movie movie) {
        if (movie == null) {
            System.out.println("No movie added to database.");
        } else {
            movies.add(movie);
        }
    }

    public Rental rent(Movie movie, Customer customer) {
        if (movie == null || customer == null) {
            System.out.println("Failed to rent the movie.");
        } else {
            if (movie.getGenre().equals(Movie.Genre.XXX) && customer.getAge() < 18) {
                throw new IllegalArgumentException("You are not old enough for this type of movie.");
            } else {
                Rental rental = new Rental(movie, customer, LocalDate.now().plus(movie.getReturnBefore()));
                rentals.add(rental);
                customer.addRentalToHistory(rental);
                return rental;
            }
        }
        return null;
    }

    public void printMovies() {
        movies.forEach(movie -> System.out.printf("[%02d] %s, %s %s price: %.2f\n", movies.indexOf(movie) + 1,
                movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getRentPrice()));
    }

    public Movie getMovieByIndex(int index) {
        return movies.get(index);
    }

    public Customer getCustomerByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equals(email))
                .findAny().orElse(null);
    }
}
