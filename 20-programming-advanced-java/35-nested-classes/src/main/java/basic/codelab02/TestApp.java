package basic.codelab02;

import java.time.LocalDate;

public class TestApp {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .withName("The Builder")
                .withFirstName("Bob")
                .withBirthday(LocalDate.of(1980,1,20))
                .withId(999)
                .build();
        System.out.println(person);
    }
}
