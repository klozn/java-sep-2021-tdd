package com.switchfully.programming.advanced.bdd;

import io.cucumber.messages.internal.com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @GetMapping
    public List<Person> getAllPersons() {
        return Lists.newArrayList(
                new Person("a", "b")
        );
    }
}
