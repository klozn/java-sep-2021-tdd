package basic.codelab03.be.switchfully.person;

import basic.codelab03.be.switchfully.address.Address;
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

    public Person removeByLastName(String lastName) {
        Person person = personRepository.findByName(lastName);
        personRepository.remove(person);
        return person;
    }
}
