package basic.selfeval.codelab01.domain;

import basic.selfeval.codelab01.Soundable;

/**
 * Read the README.md file.
 */
public class Computer implements Soundable {
    @Override
    public String makeSound() {
        return "Bleep Bloop Bleep!";
    }

}
