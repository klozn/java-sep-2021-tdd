package codelab04.domain;

import java.util.Objects;

public class Movie {
    private static final double STANDARD_RENT_PRICE = 9.99;
    private final String title;
    private final String director;
    private final Genre genre;
    private final double rentPrice;

    public Movie(String title, String director) {
        this(title, director, STANDARD_RENT_PRICE);
    }

    public Movie(String title, String director, double rentPrice) {
        this(title, director, Genre.UNDEFINED, rentPrice);
    }

    public Movie(String title, String director, Genre genre, double rentPrice) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rentPrice = rentPrice;
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

    public double getRentPrice() {
        return rentPrice;
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
