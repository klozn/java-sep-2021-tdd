package com.switchfully.programming.advanced.integration.testing.laundry;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Selenide.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaundryWebDriverTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void whenAddingLaundry_thenThatLaundryIsAvailableInTheLaundryList() {
        open("http://localhost:" + port);
        $(By.id("link-add-laundry")).click();
        $(By.id("owner")).setValue("Bob");
        $(By.id("type")).selectOption("Wool");
        $(By.id("description")).setValue("An ugly christmas sweater");
        $(By.tagName("button")).click();
        $$("#laundry-list-table tbody tr").shouldHave(anyMatch("", element -> element.getText().equals("Bob wool An ugly christmas sweater 30 false")));
    }

}
