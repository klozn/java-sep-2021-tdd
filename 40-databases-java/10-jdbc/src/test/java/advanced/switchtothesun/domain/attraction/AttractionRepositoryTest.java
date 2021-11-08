package advanced.switchtothesun.domain.attraction;

import advanced.switchtothesun.DatasourceConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.stream.Collectors;

@SpringJUnitConfig(DatasourceConfig.class)
class AttractionRepositoryTest {
    private AttractionRepository attractionRepository;

    @Autowired
    AttractionRepositoryTest(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Test
    void getAllCountries() {
        List<Attraction> attractions = attractionRepository.getAllAttractions();
        List<String> names = attractions.stream()
                .map(Attraction::getName)
                .collect(Collectors.toList());
        Assertions.assertThat(names).containsExactly("The Eifel Tower", "Côte d'azur",
                "The Colosseum", "Venice", "Seville");
    }
}
