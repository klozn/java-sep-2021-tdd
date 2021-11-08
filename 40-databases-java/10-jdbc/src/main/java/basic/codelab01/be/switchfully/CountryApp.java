package basic.codelab01.be.switchfully;

import basic.codelab01.be.switchfully.country.CountryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CountryApp {
  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CountryApp.class);
    CountryRepository countryRepository = applicationContext.getBean(CountryRepository.class);
  }
}
