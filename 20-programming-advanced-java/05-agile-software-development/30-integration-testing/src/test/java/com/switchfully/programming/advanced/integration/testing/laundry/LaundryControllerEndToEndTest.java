package com.switchfully.programming.advanced.integration.testing.laundry;

import com.switchfully.programming.advanced.integration.testing.MyTestConfiguration;
import com.switchfully.programming.advanced.integration.testing.time.TimeProviderStub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Import(MyTestConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class LaundryControllerEndToEndTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LaundryRepository laundryRepository;
    @Autowired
    private TimeProviderStub timeProviderStub;

    @AfterEach
    void tearDown() {
        timeProviderStub.reset();
    }

    @Test
    void givenLaundryInSystem_whenGettingAllLaundries_thenThisLaundryIsPresent() {
        //GIVEN
        timeProviderStub.freeze();
        laundryRepository.save(new Laundry(LaundryType.COLOR, "Gertje", "flashy Hawaiian shirt", timeProviderStub.getNow()));

        //WHEN
        ResponseEntity<LaundryDTO[]> entity = restTemplate.getForEntity("http://localhost:" + port + "/laundries", LaundryDTO[].class);

        //THEN
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isNotNull();
        assertThat(entity.getBody()).isNotEmpty();
        assertThat(Arrays.asList(entity.getBody())).contains(new LaundryDTO("color", "Gertje", "flashy Hawaiian shirt", 30L, false));
    }

    @Test
    void givenLaundryInSystem_whenGettingAllLaundries_thenThisLaundryIsPresent_restassured() {
        //GIVEN
        timeProviderStub.freeze();
        laundryRepository.save(new Laundry(LaundryType.COLOR, "Gertje", "flashy Hawaiian shirt", timeProviderStub.getNow()));

        //WHEN
        LaundryDTO[] result = given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .get("/laundries")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(LaundryDTO[].class);

        //THEN
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(Arrays.asList(result)).contains(new LaundryDTO("color", "Gertje", "flashy Hawaiian shirt", 30L, false));
    }

    @Test
    void givenLaundryInSystem_whenGettingAllLaundries_thenThisLaundryIsPresent_webTestClient() {
        //GIVEN
        WebTestClient testClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
        //WHEN
        WebTestClient.ResponseSpec response = testClient.get().uri("/laundries")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        //THEN
        response.expectStatus().isOk() // sorry, no tea pot
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(LaundryDTO.class).hasSize(6);
    }

    @Test
    void givenLaundryInSystem_whenAddingLaundry_thenOneMoreIsPresent_webTestClient() {
        //GIVEN
        WebTestClient testClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
        LaundryDTO tim = new LaundryDTO("color", "Gertje", "flashy Hawaiian shirt", 0L, false);
        //WHEN
        WebTestClient.ResponseSpec response = testClient.post().uri("/laundries")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(tim), LaundryDTO.class)
                .exchange();

        //THEN
        response.expectStatus().isOk(); // sorry, no tea pot
        assertThat(laundryRepository.findAll()).contains(laundryRepository.getLaundryByOwner("Gertje"));
    }
    // WebTestClient Pros and cons
    // Cons: Extra library (spring-webflux)
    // Cons: New programming paradigm (Reactive)


}
