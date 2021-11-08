package advanced.switchtothesun.domain.country;

import advanced.switchtothesun.resultsetmappers.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> getAll() {
        return jdbcTemplate.query("select country.id as id, country.name as country_name," +
                        " cont.id as continent_id, cont.name as continent_name from country country left join continent cont on country.fk_continent_id = cont.id",
                (resultSet, rowNumber) -> new CountryMapper().map(resultSet));
    }
}
