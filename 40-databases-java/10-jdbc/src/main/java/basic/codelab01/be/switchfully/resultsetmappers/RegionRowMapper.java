package basic.codelab01.be.switchfully.resultsetmappers;

import basic.codelab01.be.switchfully.region.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RegionRowMapper implements RowMapper<Region> {
    @Override
    public Region mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Region(resultSet.getInt("region_id"),
                resultSet.getString("region_name"));
    }
}
