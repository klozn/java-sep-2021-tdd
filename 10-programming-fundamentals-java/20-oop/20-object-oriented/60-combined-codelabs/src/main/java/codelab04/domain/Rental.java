package codelab04.domain;

import java.time.LocalDate;
import java.util.Objects;

public record Rental(Movie movie, Customer customer, LocalDate returnDate) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return movie.equals(rental.movie) && customer.equals(rental.customer) && Objects.equals(returnDate, rental.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, customer, returnDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rental{");
        sb.append("movie=").append(movie);
        sb.append(", customer=").append(customer);
        sb.append(", returnDate=").append(returnDate);
        sb.append('}');
        return sb.toString();
    }
}
