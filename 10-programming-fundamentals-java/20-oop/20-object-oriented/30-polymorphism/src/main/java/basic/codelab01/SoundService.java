package basic.codelab01;

import java.util.StringJoiner;

/**
 * Read the README.md file.
 */
public class SoundService {

    public static void main(String[] args) {
        Baby[] babies = {new Baby(), new Baby()};
        Computer[] computers = {new Computer()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        Cat[] cats = {new Cat()};
        System.out.println(allMakeSound(babies));
        System.out.println(allMakeSound(computers));
        System.out.println(allMakeSound(dogs));
        System.out.println(allMakeSound(cats));
    }

    static String allMakeSound(Soundable[] soundables) {
        StringJoiner joiner = new StringJoiner("\n");
        for(Soundable soundable : soundables) {
            joiner.add(soundable.makeSound());
        }
        return joiner.toString();
    }
}
