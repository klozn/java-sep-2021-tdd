package basic.codelab02.be.switchfully;

import basic.codelab02.be.switchfully.person.Name;
import basic.codelab02.be.switchfully.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Codelab02 implements CommandLineRunner {

    private final PersonService personService;

    @Autowired
    public Codelab02(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Codelab02.class);
    }

    @Override
    public void run(String... args) throws Exception {
//        Person leo = personService.createNewPerson("Leo", "Tielemans", null);
//        Person leo2 = personService.createNewPerson("Leo", "Tielemans", "green");
//        Person frank = personService.createNewPerson("Frank", "Kafka", "beige");
//        System.out.println(leo);
//        System.out.println(frank);
//
//        personService.setFavoriteColor("Leo", "Tielemans" , "blue");
        //System.out.println(personService.getByName(new Name("Leo", "Tielemans")));
        //personService.createNewPerson("Del", "337", null);
        Name toDelete = new Name("Del", "337");
        personService.delete(toDelete);
    }
}
