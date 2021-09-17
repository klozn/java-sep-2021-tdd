package codelab08.birds;

public class Eagle extends Bird implements Flyable {

    public Eagle() {
        super(BeakSize.LARGE);
    }

    @Override
    public String fly() {
        return "I'm soaring through the sky!";
    }

    @Override
    public int getMaxAltitude() {
        return 0;
    }
}
