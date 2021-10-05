package lambdas.advanced.codelab01;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;

/**
 * Read the README.md file
 */
class AutomatedContactService {

    public static final Predicate<Person> DRIVER_TEST = person -> person.getAge() > 16;
    public static final Predicate<Person> DRAFTEE_TEST = person -> person.getGender() == Gender.MALE
            && person.getAge() >= 18 && person.getAge() <= 25;
    public static final Predicate<Person> PILOT_TEST = person -> person.getAge() >= 23 && person.getAge() <= 65;

    String call(List<Person> pl, Predicate<Person> personPredicate) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Person p : pl) {
            if (personPredicate.test(p)) {
                joiner.add(automatedCall(p));
            }
        }
        return joiner.toString();
    }

    String email(List<Person> pl, Predicate<Person> personPredicate) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Person p : pl) {
            if (personPredicate.test(p)) {
                joiner.add(automatedEmail(p));
            }
        }
        return joiner.toString();
    }

    String mail(List<Person> pl, Predicate<Person> personPredicate) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Person p : pl) {
            if (personPredicate.test(p)) {
                joiner.add(automatedMail(p));
            }
        }
        return joiner.toString();
    }

    private String automatedCall(Person p) {
        return "Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone();
    }

    private String automatedEmail(Person p) {
        return "Emailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail();
    }

    private String automatedMail(Person p) {
        return "Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress();
    }

}
