package advanced.switchtothesun.domain.attraction;

import advanced.switchtothesun.domain.country.Continent;
import advanced.switchtothesun.domain.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name, c.id as country_id, " +
                        "cont.name as continent_name, cont.id as continent_id " +
                        "from switchtothesun.attraction a " +
                        "join switchtothesun.country c on c.id = a.fk_country_id " +
                        "join switchtothesun.continent cont on c.fk_continent_id = cont.id;",
                toRowMapper());
    }

    public List<Attraction> getByType(String type) {
        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name, c.id as country_id, " +
                        "cont.name as continent_name, cont.id as continent_id " +
                        "from switchtothesun.attraction a " +
                        "join switchtothesun.country c on c.id = a.fk_country_id " +
                        "join switchtothesun.continent cont on c.fk_continent_id = cont.id " +
                        "where type like ?;", toRowMapper(), type);
    }

    public List<Attraction> getByCountry(String countryName) {
        return jdbcTemplate.query("select a.name as attraction_name, c.name as country_name, c.id as country_id, " +
                        "cont.name as continent_name, cont.id as continent_id " +
                        "from switchtothesun.attraction a " +
                        "join switchtothesun.country c on c.id = a.fk_country_id " +
                        "join switchtothesun.continent cont on c.fk_continent_id = cont.id " +
                        "and lower(c.name) like ?;", toRowMapper(), countryName);
    }

    private RowMapper<Attraction> toRowMapper() {
        return (resultSet, rowNum) -> new Attraction(resultSet.getString("attraction_name"),
                new Country(resultSet.getInt("country_id"), resultSet.getString("country_name"),
                        new Continent(resultSet.getInt("continent_id"), resultSet.getString("continent_name"))));
    }
}

