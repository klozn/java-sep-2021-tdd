package com.switchfully.spring.dependencyinversion.backery.bread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SelfMadeBreadService implements BreadService {
    private NormalBreadRepository repository;

    @Autowired
    public SelfMadeBreadService(NormalBreadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bread getBreadByName(String name) {
        return repository.getBreadByName(name);
    }
}
