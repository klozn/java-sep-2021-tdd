package com.switchfully.programming.advanced.bdd.steps;

import com.switchfully.programming.advanced.bdd.Person;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OtherStuff {

    public List<Person> doStuff() {
        Person[] result = new RestTemplate().getForObject("http://localhost:8080/persons", Person[].class);
        return Lists.newArrayList(result);
    }
}
