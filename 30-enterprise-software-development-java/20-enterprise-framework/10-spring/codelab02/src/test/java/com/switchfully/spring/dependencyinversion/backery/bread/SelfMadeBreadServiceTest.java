package com.switchfully.spring.dependencyinversion.backery.bread;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SelfMadeBreadServiceTest {

    private SelfMadeBreadService service = new SelfMadeBreadService(new NormalBreadRepository());

    @Test
    void getBreadByNameTest() {
        Bread bread = service.getBreadByName("volkorenbrood");
        assertEquals("bruin", bread.getColor());
        assertEquals(2.5, bread.getPrice());
    }
}