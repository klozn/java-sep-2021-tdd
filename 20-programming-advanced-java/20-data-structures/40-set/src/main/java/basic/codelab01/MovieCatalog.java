package basic.codelab01;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class MovieCatalog {

    private final String name;
    private final Set<Movie> movies;

    MovieCatalog(String name) {
        this.name = name;
        movies = new HashSet<>();
    }

    MovieCatalog addMovie(Movie movie) {
        movies.add(movie);
        return this;
    }

    /**
     * Should return only the movies that exist in both movie catalogs
     */
    Movie[] getIntersectionOf(MovieCatalog otherMovieCatalog) {
        Set<Movie> intersection = new HashSet<>(movies);
        intersection.retainAll(otherMovieCatalog.movies);
        return intersection.toArray(new Movie[0]);
    }

    /**
     * Should return all the movies, of both movie catalogs combined
     */
    Movie[] getUnionOf(MovieCatalog otherMovieCatalog) {
        Set<Movie> unionMovies = new HashSet<>(movies);
        unionMovies.addAll(otherMovieCatalog.movies);
        return unionMovies.toArray(new Movie[0]);
    }

    /**
     * If this movie catalog includes all the movies of the other movie catalog, then return true.
     */
    boolean isSubsetOf(MovieCatalog otherMovieCatalog) {
        return movies.containsAll(otherMovieCatalog.movies);
    }

}
