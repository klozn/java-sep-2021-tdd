package advanced.switchtothesun;

import advanced.switchtothesun.services.CountryService;
import advanced.switchtothesun.services.AttractionService;
import advanced.switchtothesun.services.ReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Locale;
import java.util.Scanner;

@Import(value = DatasourceConfig.class)
public class SwitchToTheSun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwitchToTheSun.class);

        System.out.println("Welcome to Switch To The Sun");

        ReportService reportService = context.getBean(ReportService.class);
        CountryService countryService = context.getBean(CountryService.class);
        AttractionService attractionService = context.getBean(AttractionService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.toLowerCase(Locale.ROOT).strip().equals("quit")) {
                return;
            }
            if (line.toLowerCase(Locale.ROOT).strip().equals("report")) {
                reportService.report();
            }
            if (line.toLowerCase(Locale.ROOT).contains("add country ")) {
                try {
                    countryService.createCountry(line);
                } catch (IllegalArgumentException e) {
                    System.err.println("Illegal Argument: " + e.getMessage());
                }
            }
            if (line.toLowerCase(Locale.ROOT).contains("remove country ")) {
                try {
                    countryService.removeCountry(line);
                } catch (IllegalArgumentException e) {
                    System.err.println("Illegal Argument: " + e.getMessage());
                }
            }
            if (line.toLowerCase(Locale.ROOT).contains("find attractions with ")) {
                attractionService.printAttractionsWithType(line);
            }
            if (line.toLowerCase(Locale.ROOT).contains("find attractions in ")) {
                attractionService.printAttractionsInCountry(line);
            }

        }
    }
}
