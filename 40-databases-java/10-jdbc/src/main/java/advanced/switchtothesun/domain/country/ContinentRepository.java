package advanced.switchtothesun.domain.country;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public class ContinentRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContinentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Continent getContinentByName(String continentName) {
        Continent continent = jdbcTemplate.queryForObject("select * from switchtothesun.continent where lower(name) like ? ",
                ((resultSet, i) -> new Continent(resultSet.getInt("id"), resultSet.getString("name"))),
                "%" + continentName.toLowerCase(Locale.ROOT) + "%");
        if (continent == null) {
            throw new IllegalArgumentException("Continent " + continentName + " not found.");
        }
        return continent;
    }
}
