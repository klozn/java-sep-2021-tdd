package com.switchfully.programming.advanced.integration.testing.laundry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LaundryControllerIntegrationTest {

    @Autowired
    private LaundryController laundryController;

    @Test
    void name() {
        laundryController.addLaundry(new LaundryDTO("white","Ben","a polo shirt", 0L, false));

        List<LaundryDTO> allLaundries = laundryController.getAllLaundries();

        System.out.println(allLaundries);
    }
}
