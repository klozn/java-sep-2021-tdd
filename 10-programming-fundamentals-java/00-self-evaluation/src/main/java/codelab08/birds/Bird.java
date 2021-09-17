package codelab08.birds;

public abstract class Bird {

    private final BeakSize beakSize;

    public Bird(BeakSize beakSize) {
        this.beakSize = beakSize;
    }

    public BeakSize getBeakSize() {
        return beakSize;
    }
}
