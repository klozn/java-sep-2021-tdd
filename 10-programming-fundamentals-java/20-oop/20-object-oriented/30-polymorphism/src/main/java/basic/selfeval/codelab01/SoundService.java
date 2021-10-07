package basic.selfeval.codelab01;

import basic.selfeval.codelab01.domain.*;

import java.util.List;
import java.util.StringJoiner;

/**
 * Read the README.md file.
 */
public class SoundService {

    public static void main(String[] args) {
        List<Soundable> soundMakers = List.of(new Baby(), new Baby(), new Computer(),
                new Dog(), new Dog(), new Cat(), new Piano());
        System.out.println(allMakeSound(soundMakers));
    }

    static String allMakeSound(List<Soundable> soundables) {
        StringJoiner joiner = new StringJoiner("\n");
        soundables.forEach(s -> joiner.add(s.makeSound()));
        return joiner.toString();
    }
}
