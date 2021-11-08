package advanced.switchtothesun.services;

import advanced.switchtothesun.domain.attraction.AttractionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AttractionService {
    private final AttractionRepository repository;
    private final CountryService countryService;

    @Autowired
    public AttractionService(AttractionRepository repository, CountryService countryService) {
        this.repository = repository;
        this.countryService = countryService;
    }

    public void printAttractionsWithType(String line) {
        String type = StringUtils.substringAfter(line.toLowerCase(Locale.ROOT), "with ")
                .strip().toUpperCase(Locale.ROOT);
        repository.getByType(type).forEach(System.out::println);
    }

    public void printAttractionsInCountry(String line) {
        String countryName = StringUtils.substringAfter(line.toLowerCase(Locale.ROOT), "in ").strip();
        repository.getByCountry(countryName).forEach(System.out::println);
    }
}
