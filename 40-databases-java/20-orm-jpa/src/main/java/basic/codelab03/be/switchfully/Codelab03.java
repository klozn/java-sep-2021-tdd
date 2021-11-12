package basic.codelab03.be.switchfully;

import basic.codelab03.be.switchfully.address.Address;
import basic.codelab03.be.switchfully.hobby.Hobby;
import basic.codelab03.be.switchfully.hobby.HobbyService;
import basic.codelab03.be.switchfully.person.Person;
import basic.codelab03.be.switchfully.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Codelab03 implements CommandLineRunner {

    private final PersonService personService;
    private final HobbyService hobbyService;

    @Autowired
    public Codelab03(PersonService personService, HobbyService hobbyService) {
        this.personService = personService;
        this.hobbyService = hobbyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Codelab03.class);
    }

    @Override
    public void run(String... args) throws Exception {
//        personService.createNewPerson("Klaas", "Devits", new Address("WillowStreet", "47", "Brussels", 1000));
        //System.out.println(personService.removeByName("Klaas", "Devits"));

        Person klaas = personService.findByName("Klaas", "Devits");
        Hobby hobby = hobbyService.createNewHobby("Tetris", "ESport");
        System.out.println(klaas);
        personService.assignHobby(klaas.getId(), hobby);
        System.out.println(personService.findByName("Klaas", "Devits"));
    }
}
