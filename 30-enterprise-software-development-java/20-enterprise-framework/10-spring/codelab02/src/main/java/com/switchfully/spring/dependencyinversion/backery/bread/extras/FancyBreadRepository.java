package com.switchfully.spring.dependencyinversion.backery.bread.extras;

import com.google.common.collect.ImmutableMap;
import com.switchfully.spring.dependencyinversion.backery.bread.Bread;
import com.switchfully.spring.dependencyinversion.backery.bread.BreadRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("fancy")
public class FancyBreadRepository implements BreadRepository {

    Map<String, Bread> breadRepo = ImmutableMap.<String, Bread>builder()
            .put("rozijnenbrood", new Bread("rozijnenbrood", "wit", 3))
            .put("discobrood", new Bread("discobrood", "rood, groen en geel", 4))
            .put("steppebrood", new Bread("steppebrood", "steppebruin", 8))
            .build();

    @Override
    public Bread getBreadByName(String name) {
        return breadRepo.get(name);
    }
}
