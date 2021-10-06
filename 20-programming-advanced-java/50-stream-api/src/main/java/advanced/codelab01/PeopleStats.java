package advanced.codelab01;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class PeopleStats {

    public static IntSummaryStatistics getStats(List<Person> people) {
        return people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));
    }
}
