package solutions.codelab11.staff;

import solutions.codelab11.food.Food;
import solutions.codelab11.house.Diningroom;

public class Butler {

    private final String name;

    public Butler(String name) {
        this.name = name;
    }

    void serveFood(Food food, Diningroom diningroom) {
        System.out.println("Butler " + name + " is serving " + food + " in the dining room");
        diningroom.serveFood(food);
    }
}
