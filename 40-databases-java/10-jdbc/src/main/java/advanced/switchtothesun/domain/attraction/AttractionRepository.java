package advanced.switchtothesun.domain.attraction;

import advanced.switchtothesun.domain.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttractionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AttractionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Attraction> getAllAttractions() {
        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name " +
                        "from switchtothesun.attraction a " +
                        "join switchtothesun.country c on c.id = a.fk_country_id;",
                (resultSet, rowNum) -> new Attraction(resultSet.getString("attraction_name"),
                        new Country(0, resultSet.getString("country_name"), null)));
    }

    public List<Attraction> getByType(String type) {
        return jdbcTemplate.query("select a.name as attraction_name, a.type as attraction_type, c.name as country_name " +
                        "from switchtothesun.attraction a " +
                        "join switchtothesun.country c on c.id = a.fk_country_id " +
                        "where type like '%" + type + "%';",
                ((resultSet, i) -> new Attraction(resultSet.getString("attraction_name"),
                        new Country(0, resultSet.getString("country_name"), null))));
    }

    public List<Attraction> getByCountry(String countryName) {
        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name " +
                        "from switchtothesun.attraction a " +
                        "join switchtothesun.country c on a.fk_country_id = c.id " +
                        "and lower(c.name) like '" + countryName.toLowerCase() + "';",
                (resultSet, i) -> new Attraction(resultSet.getString("attraction_name"),
                        new Country(0, resultSet.getString("country_name"), null)));
    }
}
