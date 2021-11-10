package advanced.switchtothesun.services;

import advanced.switchtothesun.domain.country.Continent;
import advanced.switchtothesun.domain.country.ContinentRepository;
import advanced.switchtothesun.domain.country.Country;
import advanced.switchtothesun.domain.country.CountryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CountryService {
    private final CountryRepository repository;
    private final ContinentRepository continentRepository;

    @Autowired
    public CountryService(CountryRepository repository, ContinentRepository continentRepository) {
        this.repository = repository;
        this.continentRepository = continentRepository;
    }

    public void createCountry(String line, Continent continent) {
        String countryName = StringUtils.substringAfter(line,"country ");
        assertCountryNameDoesNotAlreadyExist(countryName);
        int id = repository.getAll().size() + 1;
        repository.save(new Country(id , countryName, continent));
    }


    public List<Country> getByContinentName(String line) {
        String continentName = StringUtils.substringAfter(line.toLowerCase(Locale.ROOT), "countries in ").strip();
        return repository.getByContinentName(continentName);
    }

    public void assertCountryNameDoesNotAlreadyExist(String countryName) {
        if (repository.getAll().stream()
                .map(Country::getName)
                .map(String::toLowerCase)
                .anyMatch(s -> s.equals(countryName.toLowerCase(Locale.ROOT)))) {
            throw new IllegalArgumentException(countryName + " already exists in the database.");
        }
    }

    public void removeCountry(String line) {
        String countryName = StringUtils.substringAfter(line, "country ");
        int id = repository.getIdByName(countryName);
        try {
            repository.remove(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException(countryName + " can't be removed. It is linked to other data objects. ");
        }
    }

    public void printCountriesInContinent(String line) {
        getByContinentName(line).forEach(System.out::println);
    }

    public Continent getContinentByName(String continentName) {
        return continentRepository.getContinentByName(continentName);
    }
}
