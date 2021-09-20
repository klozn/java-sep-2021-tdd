package codelab04;

import codelab04.domain.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class RentalStoreService {
    private static final Period RETURN_BEFORE = Period.ofDays(3);
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

    public void rent(Movie movie, Customer customer) {
        if (movie == null || customer == null) {
            System.out.println("Failed to rent the movie.");
        } else {
            if (rentalCount == 20) {
                System.out.println("Rental database full.");
            } else {
                rentals[rentalCount++] = new Rental(movie, customer, LocalDate.now().plus(RETURN_BEFORE));
                customer.addRentalToHistory(rentals[rentalCount - 1]);
            }
        }
    }

    public void printMovies() {
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            System.out.printf("[%20d] %s %s %s %.2f", i, movie.getTitle(), movie.getDirector(),
                                                            movie.getGenre(), movie.getRentPrice());
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
                .filter(customer -> email.equals(customer.getEmail()))
                .findAny().orElse(null);
    }
}
