package advanced.codelab02;

import advanced.codelab02.movies.ChildrensMovie;
import advanced.codelab02.movies.NewRelease;
import advanced.codelab02.movies.RegularMovie;

public class MovieRentalUtil {
    private static final double REGULAR_MOVIE_PRICE = 2;
    private static final int RENTAL_DAYS_INCLUDED_REGULAR = 2;
    private static final int RENTAL_DAYS_INCLUDED_CHILDREN_MOVIE = 3;
    private static final double PER_DAY_PRICE = 1.5;
    private static final double NEW_RELEASE_PRICE = 3;
    private static final double CHILDREN_MOVIE_PRICE = 1.5;

    public static int calcFrequenterPoints(Rental rental) {
        if (rental.isNewReleaseRental() && rental.getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }

    public static double calcRentalPrice(Rental rental) {
        double price = 0;
        switch (rental.getMoviePriceCode()) {
            case RegularMovie.PRICE_CODE -> {
                price += REGULAR_MOVIE_PRICE;
                if (rental.getDaysRented() > RENTAL_DAYS_INCLUDED_REGULAR)
                    price += (rental.getDaysRented() - RENTAL_DAYS_INCLUDED_REGULAR) * PER_DAY_PRICE;
            }
            case NewRelease.PRICE_CODE -> price += rental.getDaysRented() * NEW_RELEASE_PRICE;
            case ChildrensMovie.PRICE_CODE -> {
                price += CHILDREN_MOVIE_PRICE;
                if (rental.getDaysRented() > RENTAL_DAYS_INCLUDED_CHILDREN_MOVIE)
                    price += (rental.getDaysRented() - RENTAL_DAYS_INCLUDED_CHILDREN_MOVIE) * PER_DAY_PRICE;
            }
        }
        return price;
    }
}
