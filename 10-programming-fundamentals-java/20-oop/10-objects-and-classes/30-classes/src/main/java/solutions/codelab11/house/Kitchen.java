package solutions.codelab11.house;

import solutions.codelab11.food.Food;

public class Kitchen {
    public Food prepareFood(String foodName) {
        System.out.println("Kitchen: preparing " + foodName);
        return new Food(foodName);
    }
}
