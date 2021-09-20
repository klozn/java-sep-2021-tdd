package codelab08;

import codelab08.birds.*;

public class Main {
    public static void main(String[] args) {
        Flyable[] flyingBirds = new Flyable[] {
                new Eagle(), new Pigeon(), new Pigeon(), new Eagle(),
                new Pigeon(), new Eagle(), new Eagle(), new Pigeon()
        };

        Bird dodo = new Dodo();
        System.out.println("Dodo beak size = " + dodo.getBeakSize());

        Sky.letAllFly(flyingBirds);
        for (Flyable flyingBird : flyingBirds) {
            System.out.println(flyingBird.getMaxAltitude());
        }
    }
}
