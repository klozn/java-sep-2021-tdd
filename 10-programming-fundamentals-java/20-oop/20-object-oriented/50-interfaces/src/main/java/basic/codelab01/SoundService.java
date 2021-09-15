package basic.codelab01;

import java.util.StringJoiner;

/**
 * Read the README.md file.
 */
public class SoundService {

    public static void main(String[] args) {
        Soundable[] soundables = {new Baby(), new Baby(), new Computer(),
                new Dog(), new Dog(), new Dog(), new Cat(), new Piano()};
        System.out.println(allMakeSound(soundables));
    }

    static String allMakeSound(Soundable[] soundables) {
        StringJoiner joiner = new StringJoiner("\n");
        for(Soundable soundable : soundables) {
            joiner.add(soundable.makeSound());
        }
        return joiner.toString();
    }
}