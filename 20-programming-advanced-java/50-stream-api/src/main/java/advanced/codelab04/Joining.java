package advanced.codelab04;

import java.util.List;
import java.util.StringJoiner;

public class Joining {

    public static String namesToString(List<Person> people) {
        final StringJoiner sj = new StringJoiner(", ", "Names: ", ".");
        people.stream()
                .map(Person::getName)
                .forEach(sj::add);
        return sj.toString();
    }

}
