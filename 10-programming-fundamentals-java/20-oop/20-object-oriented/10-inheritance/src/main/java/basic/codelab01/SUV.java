package basic.codelab01;

import java.awt.*;

public class SUV extends Car {
    private boolean fourWheelDrive;

    public SUV() {
        super();
    }

    public SUV(int id, String model, Color color) {
        this(id, model, color, false);
    }

    public SUV(int id, String model, Color color, boolean fourWheelDrive) {
        super(id, model, color);
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public String getHorsePower() {
        return "200hp";
    }
}
