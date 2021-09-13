package basic.codelab01;

import java.awt.*;

public class SportsCar extends Car {
    public SportsCar() {
        super();
    }

    public SportsCar(int id, String model, Color color) {
        super(id, model, color);
    }

    @Override
    public String getHorsePower() {
        return "350hp";
    }

    @Override
    public void turnOnEngine() {
        System.out.println("Brabrabrabraaa");
    }
}
