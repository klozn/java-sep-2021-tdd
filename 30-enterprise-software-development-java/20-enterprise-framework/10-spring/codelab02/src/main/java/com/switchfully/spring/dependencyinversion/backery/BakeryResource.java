package com.switchfully.spring.dependencyinversion.backery;

import com.switchfully.spring.dependencyinversion.backery.bread.Bread;
import com.switchfully.spring.dependencyinversion.backery.bread.SelfMadeBreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BakeryResource {
    private final SelfMadeBreadService service;

    @Autowired
    public BakeryResource(SelfMadeBreadService service) {
        this.service = service;
    }

    public Bread getBreadByName(String name) {
        return service.getBreadByName(name);
   }


}
