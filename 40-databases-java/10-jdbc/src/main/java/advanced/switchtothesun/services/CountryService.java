package advanced.switchtothesun.services;

import advanced.switchtothesun.domain.country.Country;
import advanced.switchtothesun.domain.country.CountryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CountryService {
    private final CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public void createCountry(String line) {
        String countryName = StringUtils.substringAfter(line,"country ");
        assertCountryNameDoesNotAlreadyExist(countryName);
        int id = repository.getAll().size() + 1;
        repository.save(new Country(id , countryName, null));
    }

    public Country getById(int id) {
        return repository.getById(id);
    }

    private void assertCountryNameDoesNotAlreadyExist(String countryName) {
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

}
