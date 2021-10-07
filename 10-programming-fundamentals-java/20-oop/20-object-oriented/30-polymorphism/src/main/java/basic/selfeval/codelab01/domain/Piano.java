package basic.selfeval.codelab01.domain;

import basic.selfeval.codelab01.Soundable;

public class Piano implements Soundable {
    @Override
    public String makeSound() {
        return "Elize, this one's for you.";
    }
}
