package advanced.switchtothesun;

import advanced.switchtothesun.domain.attraction.AttractionRepository;
import advanced.switchtothesun.domain.country.CountryRepository;
import advanced.switchtothesun.domain.metadata.MetaDataRepository;
import advanced.switchtothesun.services.ReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@Import(value = DatasourceConfig.class)
public class SwitchToTheSun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwitchToTheSun.class);

        System.out.println("Welcome to Switch To The Sun");

        ReportService reportService = context.getBean(ReportService.class);

        Scanner scanner = new Scanner(System.in);

        while(true){
            reportService.report();
            String line = scanner.nextLine();
            if(line.equals("quit")){
                return;
            }
        }
    }
}
