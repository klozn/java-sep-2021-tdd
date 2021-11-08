package advanced.switchtothesun.resultsetmappers;

import advanced.switchtothesun.country.Continent;
import advanced.switchtothesun.country.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements ResultSetMapper<Country>{
    @Override
    public Country map(ResultSet resultSet) throws SQLException {
        return new Country(resultSet.getInt("id"),
                resultSet.getString("country_name"),
                new Continent(resultSet.getInt("continent_id"),
                        resultSet.getString("continent_name")));
    }
}
