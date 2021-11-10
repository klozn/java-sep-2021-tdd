package basic.codelab02.be.switchfully.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person createNewPerson(String firstname, String lastname, String favoriteColor) {
        Person person = new Person(new Name(firstname, lastname), favoriteColor);
        if (personRepository.getAll().contains(person)) {
            throw new IllegalArgumentException("Person " + person + " already exists");
        }
        return personRepository.save(person);
    }

    public Person setFavoriteColor(String firstName, String lastname, String favoriteColor) {
        Person person = getByName(new Name(firstName, lastname));
        if (person == null) {
            throw new IllegalArgumentException("Person " + firstName + " " + lastname + " not found");
        }
        person.setFavoriteColor(favoriteColor);
        return person;
    }

    public Person getByName(Name name) {
        List<Person> people = personRepository.findByName(name);
        if (people.size() == 0) {
            throw new IllegalArgumentException("No person found with name " + name);
        }
        if (people.size() > 1) {
            System.out.println("\nMultiple Options:");
            Scanner scanner = new Scanner(System.in);
            people.forEach(System.out::println);
            System.out.print("\nEnter UUID:\n> ");
            String uuid = scanner.nextLine();
            return personRepository.findById(uuid);
        } else {
            return people.get(0);
        }
    }

    public Person delete(Name name) {
        Person person = getByName(name);
        personRepository.remove(person);
        return person;
    }
}
