package basic.codelab01.be.switchfully;

import basic.codelab01.be.switchfully.country.Country;
import basic.codelab01.be.switchfully.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final CountryRepository countryRepository;

    @Autowired
    public Application(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        countryRepository.getAllCountries().forEach(System.out::println);
        Country country = countryRepository.getById("BE");
        System.out.println(country);

    }
}
