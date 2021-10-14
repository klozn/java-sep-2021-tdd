package com.switchfully.spring.dependencyinversion.backery;

import com.switchfully.spring.dependencyinversion.backery.bread.Bread;
import com.switchfully.spring.dependencyinversion.backery.bread.BreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "normal | fancy | wholesale")
public class BakeryResource {
    private final BreadService service;

    @Autowired
    public BakeryResource(BreadService service) {
        this.service = service;
    }

    public Bread getBreadByName(String name) {
        return service.getBreadByName(name);
   }


}
