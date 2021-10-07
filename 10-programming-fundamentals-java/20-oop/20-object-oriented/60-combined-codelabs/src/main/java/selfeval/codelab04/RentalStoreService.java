package selfeval.codelab04;

import selfeval.codelab04.domain.Customer;
import selfeval.codelab04.domain.Genre;
import selfeval.codelab04.domain.Movie;
import selfeval.codelab04.domain.Rental;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class RentalStoreService {
    private final Customer[] customers;
    private final Movie[] movies;
    private final Rental[] rentals;
    private static int customerCount;
    private static int movieCount;
    private static int rentalCount;

    public RentalStoreService() {
        customers = new Customer[5];
        movies = new Movie[10];
        rentals = new Rental[20];
        DatabaseInitializer.populate(movies);
        movieCount = 4;
        DatabaseInitializer.populate(customers);
        customerCount = 1;
    }

    public void addNewCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("No customer added to database.");
        }
        if (customerCount == 5) {
            System.out.println("Customer database full.");
        } else {
            customers[customerCount++] = customer;
        }
    }

    public void addNewMovie(Movie movie) {
        if (movie == null) {
            System.out.println("No movie added to database.");
        }
        if (movieCount == 10) {
            System.out.println("Movie database full.");
        } else {
            movies[movieCount++] = movie;
        }
    }

    public Rental rent(Movie movie, Customer customer) {
        if (movie == null || customer == null) {
            System.out.println("Failed to rent the movie.");
        } else {
            if (movie.getGenre().equals(Genre.XXX) && customer.getAge() < 18) {
                System.out.println("You are not old enough for this type of movie.");
            } else {
                if (rentalCount == 20) {
                    System.out.println("Rental database full.");
                } else {
                    Rental rental = new Rental(movie, customer, LocalDate.now().plus(movie.getReturnBefore()));
                    rentals[rentalCount++] = rental;
                    customer.addRentalToHistory(rental);
                    return rental;
                }
            }
        }
        return null;
    }

    public void printMovies() {
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            if (movie != null) {
                System.out.printf("[%02d] %s, %s %s price: %.2f\n", i + 1, movie.getTitle(), movie.getDirector(),
                        movie.getGenre(), movie.getRentPrice());
            }
        }
    }

    public Movie getMovieByIndex(int index) {
        if (index < 0 || index >= movies.length) {
            System.out.println("Movie not found");
            return null;
        }
        return movies[index];
    }

    public Customer getCustomerByEmail(String email) {
        return Arrays.stream(customers)
                .filter(Objects::nonNull)
                .filter(customer -> email.equals(customer.getEmail()))
                .findAny().orElse(null);
    }
}
