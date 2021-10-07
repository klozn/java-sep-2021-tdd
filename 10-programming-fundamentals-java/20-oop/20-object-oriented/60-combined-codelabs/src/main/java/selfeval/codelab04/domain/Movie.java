package selfeval.codelab04.domain;

import java.time.Period;
import java.util.Objects;

public class Movie {
    private static final double ONE_DAY_RENT_PRICE = 4.95;
    private static final double TRENDING_RENT_PRICE = 9.95;
    private static final double OLD_MOVIE_RENT_PRICE = 6.95;
    private final String title;
    private final String director;
    private final Genre genre;
    private double rentPrice;
    private MovieStatus status;
    private Period returnBefore;

    public Movie(String title, String director) {
        this(title, director, Genre.UNDEFINED, MovieStatus.ONE_DAY_MOVIE);
        status = MovieStatus.ONE_DAY_MOVIE;
        returnBefore = Period.ofDays(1);
    }

    public Movie(String title, String director, Genre genre, MovieStatus status) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.status = status;
        rentPrice = switch (status) {
            case ONE_DAY_MOVIE -> ONE_DAY_RENT_PRICE;
            case TRENDING_MOVIE -> TRENDING_RENT_PRICE;
            case OLDER_MOVIE -> OLD_MOVIE_RENT_PRICE;
        };
        returnBefore = status.equals(MovieStatus.ONE_DAY_MOVIE) ? Period.ofDays(1) : Period.ofDays(3);
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Genre getGenre() {
        return genre;
    }

    public MovieStatus getStatus() {
        return status;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public Period getReturnBefore() {
        return returnBefore;
    }

    public void downGrade() {
        status = status.downGrade();
        if (status.equals(MovieStatus.TRENDING_MOVIE)) {
            rentPrice = TRENDING_RENT_PRICE;
        } else {
            rentPrice = OLD_MOVIE_RENT_PRICE;
        }
        returnBefore = Period.ofDays(3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("title='").append(title).append('\'');
        sb.append(", director='").append(director).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", rentPrice=").append(rentPrice);
        sb.append('}');
        return sb.toString();
    }
}
