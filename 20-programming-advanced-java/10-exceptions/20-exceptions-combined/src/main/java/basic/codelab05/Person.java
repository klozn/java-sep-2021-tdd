package basic.codelab05;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDay;
    private final Address address;

    public Person(String firstName, String lastName, LocalDate birthDay, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }
}
