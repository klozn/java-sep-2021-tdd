package advanced.codelab02;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18, Collectors.toList()));
    }
}
