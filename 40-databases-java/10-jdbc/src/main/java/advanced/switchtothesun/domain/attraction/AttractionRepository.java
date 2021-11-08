package advanced.switchtothesun.domain.attraction;

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
        return jdbcTemplate.query("select * from switchtothesun.attraction;",
                (resultSet, rowNum) -> new Attraction(resultSet.getString("name")));
    }

    public List<Attraction> getByType(String type) {
        return jdbcTemplate.query("select name, type from switchtothesun.attraction where type like '%" + type + "%';",
                ((resultSet, i) -> new Attraction(resultSet.getString("name"))));
    }

    public List<Attraction> getByCountry(String countryName) {
        return jdbcTemplate.query("select a.name as name, c.name from switchtothesun.attraction a " +
                        "join switchtothesun.country c on a.fk_country_id = c.id " +
                        "and lower(c.name) like '" + countryName.toLowerCase() + "';",
                (resultSet, i) -> new Attraction(resultSet.getString("name")));
    }
}
