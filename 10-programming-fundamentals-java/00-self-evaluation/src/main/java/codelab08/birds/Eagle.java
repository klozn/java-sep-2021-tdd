package codelab08.birds;

import java.util.Random;

public class Eagle extends Bird implements Flyable {
    private int maxAltitude;

    public Eagle() {
        super(BeakSize.LARGE);
        setMaxAltitude(new Random().nextInt(1001) + 4000);
    }

    public void setMaxAltitude(int maxAltitude) {
        if (maxAltitude >= 4000 && maxAltitude <= 5000) {
            this.maxAltitude = maxAltitude;
        } else {
            throw new IllegalArgumentException("Eagle should have max altitude between 4 and 5 thousand meters.");
        }
    }

    @Override
    public String fly() {
        return "I'm soaring through the sky!";
    }

    @Override
    public int getMaxAltitude() {
        return maxAltitude;
    }
}
