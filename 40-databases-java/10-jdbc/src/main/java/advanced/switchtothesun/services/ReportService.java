package advanced.switchtothesun.services;

import advanced.switchtothesun.domain.attraction.Attraction;
import advanced.switchtothesun.domain.attraction.AttractionRepository;
import advanced.switchtothesun.domain.country.Country;
import advanced.switchtothesun.domain.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final AttractionService attractionService;
    private final CountryRepository countryRepository;
    private final MetaDataService metaDataService;

    @Autowired
    public ReportService(AttractionService attractionService, CountryRepository countryRepository, MetaDataService metaDataService) {
        this.attractionService = attractionService;
        this.countryRepository = countryRepository;
        this.metaDataService = metaDataService;
    }

    public void report() {
        int nrOfVisits = metaDataService.incrementNrOfVisits();
        System.out.println("|Report|\n\nAttractions:");
        attractionService.printAllAttractions();
        System.out.println("\nCountries:");
         List<Country> countries = countryRepository.getAll();
         for (Country country: countries) {
             System.out.printf("%s, %s", country.getName(), country.getContinent().getName() + "\n");
         }
        System.out.printf("\nNumber of Visits: %d\n", nrOfVisits);
    }
}
