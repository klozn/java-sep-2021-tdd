package codelab01;

public class GenderChecker {
    public static void main(String[] args) {
        Human[] humans = new Human[] {
                new Human("Robin", "Roodbaard", Gender.MALE),
                new Human("Robine", "Roodtaart", Gender.FEMALE),
                new Human("Bob", "Ientje", Gender.OTHER)
        };

        for (Human human : humans) {
            System.out.println(human);
        }
    }
}
