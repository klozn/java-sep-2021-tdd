package advanced.switchtothesun;

import advanced.switchtothesun.attraction.AttractionRepository;
import advanced.switchtothesun.DatasourceConfig;
import advanced.switchtothesun.country.CountryRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@Import(value = DatasourceConfig.class)
public class SwitchToTheSun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwitchToTheSun.class);

        System.out.println("Welcome to Switch To The Sun");

        AttractionRepository attractionRepository = context.getBean(AttractionRepository.class);
        attractionRepository.getAllAttractions().forEach(System.out::println);
        CountryRepository countryRepository = context.getBean(CountryRepository.class);
        countryRepository.getAll().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            if(line.equals("quit")){
                return;
            }
        }
    }
}
