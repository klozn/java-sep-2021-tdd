package com.switchfully.spring.dependencyinversion.backery.bread;

import org.springframework.stereotype.Component;

@Component
public class NetworkConnectionToWholeSale {

    public Bread getBreadByName(String name) {

        return new Bread(name, name, 1);
    }
}
