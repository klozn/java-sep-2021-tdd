package basic.codelab01.be.switchfully.resultsetmappers;

import basic.codelab01.be.switchfully.country.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper {
    public Country map(ResultSet resultSet) throws SQLException {
        return new Country(
                resultSet.getString("country_id"),
                resultSet.getString("country_name"),
                new RegionRowMapper().mapRow(resultSet, resultSet.getRow()));
    }
}
