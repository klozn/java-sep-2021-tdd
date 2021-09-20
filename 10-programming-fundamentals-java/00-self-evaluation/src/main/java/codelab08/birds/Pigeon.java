package codelab08.birds;

import java.util.Random;

public class Pigeon extends Bird implements Flyable {
    private int maxAltitude;

    public Pigeon() {
        this(new Random().nextInt(251) + 500);
    }

    public Pigeon(int maxAltitude) {
        super(BeakSize.MEDIUM);
        this.maxAltitude = maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        if (maxAltitude >= 500 && maxAltitude <= 750) {
            this.maxAltitude = maxAltitude;
        } else {
            throw new IllegalArgumentException("Pigeon should have max altitude between 500 and 750 meters.");
        }
    }

    @Override
    public String fly() {
        return "Flap flap... ooh, look, breadcrumbs!";
    }

    @Override
    public int getMaxAltitude() {
        return maxAltitude;
    }
}
