package com.switchfully.spring.dependencyinversion.backery.bread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"fancy", "normal"})
public class SelfMadeBreadService implements BreadService {
    private final BreadRepository repository;

    @Autowired
    public SelfMadeBreadService(BreadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bread getBreadByName(String name) {
        return repository.getBreadByName(name);
    }
}
