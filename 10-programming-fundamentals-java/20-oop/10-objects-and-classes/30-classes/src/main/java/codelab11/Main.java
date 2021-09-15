package codelab11;

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
        House house = new House();
        house.bathroom = new Bathroom();
        house.kitchen = new Kitchen();
        house.diningroom = new Diningroom();
        house.garden = new Garden();
        house.staff = new Staff();
        house.staff.gardener = new Gardener("Patrick");
        house.staff.butler = new Butler("Sofia");
        house.staff.cook = new Cook("Hendrick");
        house.staff.plumber = new Plumber("Alexia");

        house.staff.gardener.tendTo(house.garden);
        System.out.println("********************");
        house.staff.butler.serveFood(house.staff.cook.prepareFood(house.kitchen), house.diningroom);
        System.out.println("********************");
        house.staff.plumber.fixBathroom(house.bathroom);
    }
}
