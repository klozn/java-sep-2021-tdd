package basic.codelab01.be.switchfully.country;

import basic.codelab01.be.switchfully.region.Region;
import basic.codelab01.be.switchfully.resultsetmappers.CountryMapper;
import basic.codelab01.be.switchfully.resultsetmappers.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> getAllCountries() throws SQLException {
        CountryMapper mapper = new CountryMapper();
        return jdbcTemplate.query("select * from countries c join regions r on r.region_id = c.region_id;",
                ((resultSet, rowNumber) -> mapper.map(resultSet)));
    }


    public void addCountry(Country country) {
        jdbcTemplate.update("insert into countries (country_id, country_name, region_id) " +
                "values ('"+ country.getId() + "', '" + country.getCountryName() + "', " + country.getRegion() + ");");
    }
}
