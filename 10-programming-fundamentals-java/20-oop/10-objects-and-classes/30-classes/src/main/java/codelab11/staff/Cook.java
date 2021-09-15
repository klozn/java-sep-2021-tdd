package codelab11.staff;

import codelab11.Food;
import codelab11.house.Kitchen;

public class Cook {

    public String name;

    public Cook(String name) {
        this.name = name;
    }

    public Food prepareFood(Kitchen kitchen) {
        System.out.println("Cook " + name + " is preparing some tasty chicken");
        return kitchen.prepareFood("Tasty chicken");
    }
}
