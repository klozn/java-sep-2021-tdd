package com.switchfully.programming.advanced.integration.testing.laundry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LaundryRepositoryIntegrationTest {

    @Autowired
    private LaundryRepository laundryRepository;

    @Test
    void whenSavingAnEntityInDB_ThenYouCanRetrieveIt() {
        Laundry laundry = new Laundry(LaundryType.WHITE, "Ben", "a polo shirt", LocalDateTime.now());
        laundryRepository.save(laundry);

        List<Laundry> all = laundryRepository.findAll();

        assertThat(all).hasSize(2);
        assertThat(all).contains(laundry);
    }

    // The @DataJpaTest slice ONLY loads the persistence layer
//    @Autowired LaundryController laundryController;
//    @Autowired LaundryService laundryService;
    // @DataJpaTest uses an in-memory database - unless you say otherwise
}
