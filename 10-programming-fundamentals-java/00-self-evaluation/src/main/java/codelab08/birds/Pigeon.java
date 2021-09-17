package codelab08.birds;

public class Pigeon extends Bird implements Flyable {

    public Pigeon() {
        super(BeakSize.MEDIUM);
    }

    @Override
    public String fly() {
        return "Flap flap... ooh, look, breadcrumbs!";
    }

    @Override
    public int getMaxAltitude() {
        return 0;
    }
}
