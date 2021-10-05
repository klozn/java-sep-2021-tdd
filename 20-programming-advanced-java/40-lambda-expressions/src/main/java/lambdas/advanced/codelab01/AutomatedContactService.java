package lambdas.advanced.codelab01;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Read the README.md file
 */
class AutomatedContactService {

    public static final Predicate<Person> DRIVER_TEST = person -> person.getAge() > 16;
    public static final Predicate<Person> DRAFTEE_TEST = person -> person.getGender() == Gender.MALE
            && person.getAge() >= 18 && person.getAge() <= 25;
    public static final Predicate<Person> PILOT_TEST = person -> person.getAge() >= 23 && person.getAge() <= 65;
    public static final Function<Person, String> CALL_FUNCTION =
            p -> "Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone();
    public static final Function<Person, String> EMAIL_FUNCTION =
            p -> "Emailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail();
    public static final Function<Person, String> MAIL_FUNCTION =
            p -> "Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress();

    String contact(List<Person> pl, Function<Person, String> function, Predicate<Person> predicate) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Person p : pl) {
            if (predicate.test(p)) {
                joiner.add(function.apply(p));
            }
        }
        return joiner.toString();
    }

}
