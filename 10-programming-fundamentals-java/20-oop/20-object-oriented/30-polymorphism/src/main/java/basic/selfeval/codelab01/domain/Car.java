package basic.selfeval.codelab01.domain;

import basic.selfeval.codelab01.Soundable;

public class Car implements Soundable {
    @Override
    public String makeSound() {
        return "Tuut tuut!";
    }
}
