package com.switchfully.programming.advanced.bdd.steps;

import com.switchfully.programming.advanced.bdd.Person;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class ThingySteps {

    private OtherStuff otherStuff;

    public ThingySteps(OtherStuff otherStuff) {
        this.otherStuff = otherStuff;
    }

    @When("doing stuff")
    public void doingStuff() {
        List<Person> people = otherStuff.doStuff();

        Assertions.assertThat(people).contains(new Person("a", "b"));
    }
}
