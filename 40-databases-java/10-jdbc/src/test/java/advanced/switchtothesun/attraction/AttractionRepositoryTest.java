package advanced.switchtothesun.attraction;

import advanced.switchtothesun.DatasourceConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(DatasourceConfig.class)
class AttractionRepositoryTest {
    private AttractionRepository attractionRepository;

    @Autowired
    AttractionRepositoryTest(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Test
    void getAllCountries() {
        Assertions.assertThat(true).isFalse();
    }
}
