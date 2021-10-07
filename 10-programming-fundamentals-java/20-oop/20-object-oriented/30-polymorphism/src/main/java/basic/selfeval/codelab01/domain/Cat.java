package basic.selfeval.codelab01.domain;

import basic.selfeval.codelab01.Soundable;

/**
 * Read the README.md file.
 */
public class Cat implements Soundable {
    @Override
    public String makeSound() {
        return "Miauw!";
    }

}
