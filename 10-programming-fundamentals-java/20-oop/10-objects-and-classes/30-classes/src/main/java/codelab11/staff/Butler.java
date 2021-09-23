package codelab11.staff;

import codelab11.house.Diningroom;
import codelab11.Food;

public class Butler {

    public String name;

    public Butler(String name) {
        this.name = name;
    }

    public void serveFood(Food food, Diningroom diningroom) {
        System.out.println("Butler " + name + " is serving " + food.getName() + " in the dining room");
        diningroom.serveFood(food);
    }

    public void tendTo(Garden garden) {
        System.out.println("Gardener " + name + " will (try his best to) tend to the garden.");
        garden.removeWeeds();
        garden.trimHedge();
        garden.mowGrass();
    }
}
