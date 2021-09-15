package solutions.codelab11.staff;

import solutions.codelab11.food.Food;
import solutions.codelab11.house.Kitchen;

public class Cook {

    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    Food prepareFood(Kitchen kitchen) {
        System.out.println("Cook " + name + " is preparing some tasty chicken");
        return kitchen.prepareFood("Tasty chicken");
    }
}
