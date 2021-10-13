package com.switchfully.spring.dependencyinversion.backery.bread;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("normal")
public class NormalBreadRepository implements BreadRepository {

    Map<String, Bread> breadRepo = ImmutableMap.<String, Bread>builder()
            .put("witbrood", new Bread("witbrood", "wit", 2.20))
            .put("bruinbrood", new Bread("bruinbrood", "bruin", 2.20))
            .put("volkorenbrood", new Bread("volkorenbrood", "bruin", 2.50))
            .build();

    @Override
    public Bread getBreadByName(String name) {
        return breadRepo.get(name);
    }
}
