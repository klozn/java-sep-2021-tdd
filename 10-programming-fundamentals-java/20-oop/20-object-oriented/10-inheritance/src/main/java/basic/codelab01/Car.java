package basic.codelab01;

import java.awt.*;

public class Car {
    private int id;
    private String model;
    private Color color;

    public Car() {
    }

    public Car(int id, String model, Color color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getHorsePower() {
        return "120hp";
    }

    public void turnOnEngine() {
        System.out.println("Vroom vroom");
    }
}
