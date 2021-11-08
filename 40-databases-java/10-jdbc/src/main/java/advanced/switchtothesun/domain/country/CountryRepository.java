package advanced.switchtothesun.domain.country;

import advanced.switchtothesun.resultsetmappers.CountryMapper;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
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
                (resultSet, rowNumber) -> new CountryMapper().map(resultSet));
    }

    public void save(Country country) {
        jdbcTemplate.update("insert into switchtothesun.country (id, name) " +
                "values (" + country.getId() + ", '" + country.getName() + "');");
    }

    public int getIdByName(String countryName) {
        List<Country> countries =  jdbcTemplate.query(
                "select id, name from switchtothesun.country where lower(name) like '%" + countryName.toLowerCase(Locale.ROOT) + "%';",
                (resultSet, rowNumber) -> new Country(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        null));
        if (countries.size() == 0) {
            throw new IllegalArgumentException("No country found with name:" + countryName);
        }
        return countries.get(0).getId();

    }

    public void remove(int id) {
        jdbcTemplate.update("delete from switchtothesun.country where id = ?", id);

    }
}
