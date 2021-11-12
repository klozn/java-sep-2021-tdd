package basic.codelab03.be.switchfully.person;

import basic.codelab03.be.switchfully.address.Address;
import basic.codelab03.be.switchfully.hobby.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createNewPerson(String firstName, String lastName, Address address) {
        return personRepository.save(new Person(firstName, lastName, address));
    }

    public Person findByName(String firstName, String lastName) {
        return personRepository.findByName(firstName, lastName);
    }

    public Person removeByName(String firstName, String lastName) {
        Person person = personRepository.findByName(firstName, lastName);
        personRepository.remove(person);
        return person;
    }

    public void assignHobby(int personId, Hobby hobby) {
        personRepository.findById(personId).setHobby(hobby);
    }
}
