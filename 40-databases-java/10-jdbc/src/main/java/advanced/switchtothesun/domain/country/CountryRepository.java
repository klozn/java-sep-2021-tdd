package advanced.switchtothesun.domain.country;

import advanced.switchtothesun.resultsetmappers.CountryMapper;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public class CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> getAll() {
        return jdbcTemplate.query("select country.id as id, country.name as country_name," +
                        " cont.id as continent_id, cont.name as continent_name from switchtothesun.country country " +
                        "left join switchtothesun.continent cont on country.fk_continent_id = cont.id;",
                toRowMapper());
    }

    public void save(Country country) {
        jdbcTemplate.update("insert into switchtothesun.country (id, name, fk_continent_id) " +
                "values ( ?, ?, ?);", country.getId(), country.getName(), country.getContinent().getId());
    }

    public int getIdByName(String countryName) {
        List<Country> countries =  jdbcTemplate.query(
                "select country.id as id, country.name as country_name, " +
                        "cont.id as continent_id, cont.name as continent_name from switchtothesun.country country " +
                        "left join switchtothesun.continent cont on country.fk_continent_id = cont.id " +
                        "where lower(country.name) like ? ", toRowMapper(), countryName.toLowerCase(Locale.ROOT));

        if (countries.size() == 0) {
            throw new IllegalArgumentException("No country found with name: " + countryName);
        }
        return countries.get(0).getId();

    }

    public void remove(int id) {
        jdbcTemplate.update("delete from switchtothesun.country where id = ?", id);

    }

    public List<Country> getByContinentName(String continentName) {
        return jdbcTemplate.query("select country.id as id, country.name as country_name," +
                " cont.id as continent_id, cont.name as continent_name from switchtothesun.country country " +
                "join switchtothesun.continent cont on country.fk_continent_id = cont.id " +
                        "and lower(cont.name) like ?",
                toRowMapper(), continentName.toLowerCase(Locale.ROOT));
    }

    private RowMapper<Country> toRowMapper() {
        return (resultSet, rowNumber) -> new CountryMapper().map(resultSet);
    }
}
