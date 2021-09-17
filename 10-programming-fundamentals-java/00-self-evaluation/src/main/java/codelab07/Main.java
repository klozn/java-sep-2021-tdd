package codelab07;

public class Main {
    public static void main(String[] args) {

        Dog[] dogs = new Dog[]{
                new Chihuahua("Richard", ChihuahuaColor.WHITE),
                new Labrador("Tony"),
                new Chihuahua("Eric", ChihuahuaColor.BLACK),
                new Labrador("Tina"),
                new Chihuahua("Eugenie", ChihuahuaColor.BROWN)
        };

        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        Dog richard = new Chihuahua("Richard", ChihuahuaColor.BROWN);
        System.out.println(richard.equals(dogs[0])); // adhering to codelab requirements
    }
}
