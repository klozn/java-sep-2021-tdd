package basic.codelab01.be.switchfully.region;

import basic.codelab01.be.switchfully.resultsetmappers.RegionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class RegionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RegionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Region getById(int regionId) throws SQLException {
        return jdbcTemplate.queryForObject("select * from regions where region_id = ?",
                new RegionRowMapper(), regionId);
    }
}
