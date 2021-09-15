package codelab11;

public class Kitchen {
    public Food prepareFood(String foodName) {
        System.out.println("Kitchen: preparing " + foodName);
        return new Food(foodName);
    }
}
