package advanced.switchtothesun;

import advanced.switchtothesun.services.CountryService;
import advanced.switchtothesun.services.ReportService;
import org.postgresql.util.PSQLException;
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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
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
            if (line.toLowerCase(Locale.ROOT).strip().equals("quit")) {
                return;
            }
        }
    }
}
