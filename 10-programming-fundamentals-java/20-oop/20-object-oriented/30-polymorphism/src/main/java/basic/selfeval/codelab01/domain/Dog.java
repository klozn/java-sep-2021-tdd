package basic.selfeval.codelab01.domain;

import basic.selfeval.codelab01.Soundable;

/**
 * Read the README.md file.
 */
public class Dog implements Soundable {
    @Override
    public String makeSound() {
        return "Nice to meet y.. I mean, WOOF WOOF WOOF!";
    }
}
