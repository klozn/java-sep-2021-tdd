package basic.codelab01.be.switchfully;

import basic.codelab01.be.switchfully.country.CountryRepository;
import basic.codelab01.be.switchfully.country.Country;
import basic.codelab01.be.switchfully.region.Region;
import basic.codelab01.be.switchfully.region.RegionRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
@ComponentScan
public class CountryApp {
  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CountryApp.class);
    CountryRepository countryRepository = applicationContext.getBean(CountryRepository.class);
    RegionRepository regionRepository = applicationContext.getBean(RegionRepository.class);
    try {
      countryRepository.getAllCountries().forEach(System.out::println);
      Region europe = regionRepository.getById(1);
      System.out.println(europe);
      //countryRepository.addCountry(new Country("PO","Portugal", europe));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
