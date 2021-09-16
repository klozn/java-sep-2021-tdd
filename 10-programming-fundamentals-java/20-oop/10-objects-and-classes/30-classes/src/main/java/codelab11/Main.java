package codelab11;

import codelab11.house.*;
import codelab11.staff.*;

public class Main {

    /**
     * This application for tending to a fancy villa is a mess.
     *      All classes are in a big pile.
     *      Encapsulation is non-existent.
     * <p>
     * Let's clean it up:
     *      1. Separate the classes into different packages
     *      2. Encapsulate as much as possible (private if possible, then package private, then protected, if nothing else goes finally public)
     *
     * Bonus (advanced) exercise:
     *      Avoid using getters as much as possible. It's a sign of feature envy/message chain (code smells).
     *      https://refactoring.guru/refactoring/smells/couplers
     */
    public static void main(String[] args) {

        Staff staff = new Staff.Builder().withGardener(new Gardener("Patrick"))
                .withButler(new Butler("Sofia"))
                .withCook(new Cook("Hendrick"))
                .withPlumber(new Plumber("Alexia"))
                .build();

        House house = new House.Builder()
                .withBathroom(new Bathroom())
                .withKitchen(new Kitchen())
                .withDiningroom(new Diningroom())
                .withGarden(new Garden())
                .withStaff(staff)
                .build();

        house.tendToGarden();
        System.out.println("********************");
        house.serveFood(house.prepareFood());
        System.out.println("********************");
        house.fixBathroom();
    }
}
