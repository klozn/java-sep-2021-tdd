package basic.codelab01.be.switchfully.resultsetmappers;

import basic.codelab01.be.switchfully.region.Region;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionMapper {

    public Region map(ResultSet resultSet) throws SQLException {
        return new Region(resultSet.getInt("region_id"),
                resultSet.getString("region_name"));
    }
}
