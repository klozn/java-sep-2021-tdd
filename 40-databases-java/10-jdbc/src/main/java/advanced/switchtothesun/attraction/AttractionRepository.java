package advanced.switchtothesun.attraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttractionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AttractionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Attraction> getAllAttractions() {
        return jdbcTemplate.query("select * from attraction;",
                (resultSet, rowNum) -> new Attraction(resultSet.getString("name")));
    }
}
