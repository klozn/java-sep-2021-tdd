package codelab08;

import codelab08.birds.Flyable;

public class Sky {

    public static void letAllFly(Flyable[] flyables) {
        for (Flyable flyable : flyables) {
            System.out.println(flyable.fly());
        }
    }
}
