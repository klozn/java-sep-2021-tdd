package basic.codelab04;

import java.util.Comparator;
import java.util.List;

public class OldestPerson {

    public static Person getOldestPerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElse(null);
    }

}
