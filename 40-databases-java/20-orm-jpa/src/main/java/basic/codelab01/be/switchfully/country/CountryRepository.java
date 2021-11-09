package basic.codelab01.be.switchfully.country;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CountryRepository() {
    }

    public List<Country> getAllCountries() {
        return entityManager.createQuery("select c from Country c", Country.class)
                .getResultList();
    }

    public Country getById(String id) {
        return entityManager.find(Country.class, id);
    }
}
