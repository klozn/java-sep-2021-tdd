package lambdas.advanced.codelab01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutomatedContactServiceTest {

    @Test
    void callDrivers() {
        List<Person> people = new ArrayList<>();
        people.add(
                new Person.Builder()
                        .withGivenName("Rob")
                        .withSurName("Butcher")
                        .withAge(21)
                        .withGender(Gender.MALE)
                        .withEmail("rob.butcher@my-email.be")
                        .withPhone("0484854502")
                        .withAddress("Koekenstraat 45, 3583 Beringen")
                        .build()
        );
        people.add(
                new Person.Builder()
                        .withGivenName("Tanya")
                        .withSurName("Tanem")
                        .withAge(25)
                        .withGender(Gender.FEMALE)
                        .withEmail("t-and-t@dynamite.com")
                        .withPhone("0485411125")
                        .withAddress("Parkstraat 12, 3000 Leuven")
                        .build()
        );
        people.add(
                new Person.Builder()
                        .withGivenName("Hannah")
                        .withSurName("Harlem")
                        .withAge(14)
                        .withGender(Gender.FEMALE)
                        .withEmail("hannah@han.nah")
                        .withPhone("0485411128")
                        .withAddress("Parkstraat 15, 3000 Leuven")
                        .build()
        );

        AutomatedContactService service = new AutomatedContactService();
        String calledDrivers = service.call(people, AutomatedContactService.DRIVER_TEST);

        assertEquals(calledDrivers, "Calling Rob Butcher age 21 at 0484854502\nCalling Tanya Tanem age 25 at 0485411125");

    }

    @Test
    void emailDraftees() {
        List<Person> people = new ArrayList<>();
        people.add(
                new Person.Builder()
                        .withGivenName("Rob")
                        .withSurName("Butcher")
                        .withAge(21)
                        .withGender(Gender.MALE)
                        .withEmail("rob.butcher@my-email.be")
                        .withPhone("0484854502")
                        .withAddress("Koekenstraat 45, 3583 Beringen")
                        .build()
        );
        people.add(
                new Person.Builder()
                        .withGivenName("Tanya")
                        .withSurName("Tanem")
                        .withAge(25)
                        .withGender(Gender.FEMALE)
                        .withEmail("t-and-t@dynamite.com")
                        .withPhone("0485411125")
                        .withAddress("Parkstraat 12, 3000 Leuven")
                        .build()
        );
        people.add(
                new Person.Builder()
                        .withGivenName("Hannah")
                        .withSurName("Harlem")
                        .withAge(16)
                        .withGender(Gender.FEMALE)
                        .withEmail("hannah@han.nah")
                        .withPhone("0485411128")
                        .withAddress("Parkstraat 15, 3000 Leuven")
                        .build()
        );

        AutomatedContactService service = new AutomatedContactService();
        String emailedDraftees = service.email(people, AutomatedContactService.DRAFTEE_TEST);

        assertEquals(emailedDraftees, "Emailing Rob Butcher age 21 at rob.butcher@my-email.be");
    }

    @Test
    void mailPilots() {
        List<Person> people = new ArrayList<>();
        people.add(
                new Person.Builder()
                        .withGivenName("Rob")
                        .withSurName("Butcher")
                        .withAge(22)
                        .withGender(Gender.MALE)
                        .withEmail("rob.butcher@my-email.be")
                        .withPhone("0484854502")
                        .withAddress("Koekenstraat 45, 3583 Beringen")
                        .build()
        );
        people.add(
                new Person.Builder()
                        .withGivenName("Tanya")
                        .withSurName("Tanem")
                        .withAge(25)
                        .withGender(Gender.FEMALE)
                        .withEmail("t-and-t@dynamite.com")
                        .withPhone("0485411125")
                        .withAddress("Parkstraat 12, 3000 Leuven")
                        .build()
        );

        AutomatedContactService service = new AutomatedContactService();
        String mailedPilots = service.mail(people, AutomatedContactService.PILOT_TEST);

        assertEquals(mailedPilots, "Mailing Tanya Tanem age 25 at Parkstraat 12, 3000 Leuven");
    }

}
