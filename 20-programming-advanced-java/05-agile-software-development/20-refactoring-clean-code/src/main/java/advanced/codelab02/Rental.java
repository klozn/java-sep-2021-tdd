package advanced.codelab02;

import advanced.codelab02.movies.Movie;
import advanced.codelab02.movies.NewRelease;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public int getMoviePriceCode() {
        return movie.getPriceCode();
    }

    public boolean isNewReleaseRental() {
        return getMoviePriceCode() == NewRelease.PRICE_CODE;
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }
}
