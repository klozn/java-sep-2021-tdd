package basic.codelab03.be.switchfully;

import basic.codelab03.be.switchfully.address.Address;
import basic.codelab03.be.switchfully.address.AddressRepository;
import basic.codelab03.be.switchfully.book.BookService;
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
    private final BookService bookService;
    private final AddressRepository addressRepository;

    @Autowired
    public Codelab03(PersonService personService, HobbyService hobbyService, BookService bookService, AddressRepository addressRepository) {
        this.personService = personService;
        this.hobbyService = hobbyService;
        this.bookService = bookService;
        this.addressRepository = addressRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Codelab03.class);
    }

    @Override
    public void run(String... args) throws Exception {
//        personService.createNewPerson("Klaas", "Devits", new Address("WillowStreet", "47", "Brussels", 1000));
        //System.out.println(personService.removeByName("Klaas", "Devits"));

//        Person klaas = personService.findByName("Klaas", "Devits");
//        Hobby hobby = hobbyService.createNewHobby("Tetris", "ESport");
//        System.out.println(klaas);
//        personService.assignHobby(klaas.getId(), hobby);
        Person klaas = personService.findByName("Klaas", "Devits");
//        Book book = bookService.createNewBook("The Hobbit", "Tolkien");
//        personService.addBookToCollection(klaas.getId(), book);
//        Book book = bookService.getBookById(13);
//        personService.removeBookFromCollection(klaas.getId(), book);
//        bookService.getAllBooks().forEach(System.out::println);
//        Book bookA = bookService.createNewBook("A deletable book", "Cortez");
//        Book bookB = bookService.createNewBook("another one", "Rohtua");
//        bookService.getAllBooks().forEach(System.out::println);
//        bookService.removeAllBooksByTitleStartingWith("a");
//        bookService.getAllBooks().forEach(System.out::println);
//        Address address = addressRepository.getAll().get(3);
//        personService.setAddress(klaas.getId(), address);
//        System.out.println(klaas);
//        System.out.println(personService.findByName("Klaas", "Devits"));
//        System.out.println(addressRepository.getAll());
//        addressRepository.remove(addressRepository.findById(2));
//        System.out.println(addressRepository.findById(0));
    }
}
