package basic.codelab01;

import java.awt.*;

public class Shop {
    private Car[] cars;

    public Shop() {
        this.cars = new Car[]{
                new Car(1,"Peugeot", Color.WHITE),
                new Car(2,"Volkswagen", Color.GRAY),
                new SportsCar(3, "Ferrari", Color.RED),
                new SportsCar(4, "Porsche", Color.YELLOW),
                new SUV(5, "Jeep", Color.GREEN, true),
                new SUV(6, "Dodge", Color.BLUE)
        };
    }

    public Car getCar(int id) {
        return cars[id];
    }
}
