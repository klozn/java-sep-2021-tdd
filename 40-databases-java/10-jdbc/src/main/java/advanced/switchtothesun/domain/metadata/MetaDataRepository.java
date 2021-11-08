package advanced.switchtothesun.domain.metadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MetaDataRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MetaDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void incrementNrOfVisits() {
        jdbcTemplate.update("update metadata set number_of_visits = number_of_visits + 1 where id = 0;");
    }

    public int getNumberOfVisits() {
        return jdbcTemplate.queryForObject("select number_of_visits from metadata where id = 0", Integer.class);
    }
}
