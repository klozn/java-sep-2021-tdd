package codelab04.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private LocalDate birthday;
    private String email;
    private boolean emailList;
    private List<Rental> rentalHistory = new ArrayList<>();

    public Customer(String name, LocalDate birthday, String email, boolean emailList) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.emailList = emailList;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public void addRentalToHistory(Rental rental) {
        if (rental != null) {
            rentalHistory.add(rental);
        }
    }

    public void printRentalHistory() {
        rentalHistory.forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", email='").append(email).append('\'');
        sb.append(", emailList=").append(emailList);
        sb.append('}');
        return sb.toString();
    }
}
