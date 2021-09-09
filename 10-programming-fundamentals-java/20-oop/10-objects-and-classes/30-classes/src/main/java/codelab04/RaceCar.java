package codelab04;

public class RaceCar {
    int numberOfGears;
    int currentGear;

    public RaceCar() {
        this(6, 0);
    }

    public RaceCar(int numberOfGears, int currentGear) {
        this.numberOfGears = numberOfGears;
        this.currentGear = currentGear;
    }

    public void shiftGearUp() {
        if (currentGear != numberOfGears) {
            currentGear++;
        }
    }

    public void shiftGearDown() {
        if (currentGear != 1) {
            currentGear--;
        }
    }

    public void shiftGear(int gear) {
        if ((currentGear - gear) == 1) {
            currentGear--;
        }
        if ((currentGear - gear) == -1) {
            currentGear++;
        }
    }

    @Override
    public String toString() {
        return "Racecar with " + numberOfGears + " in total, currently in "
                + currentGear + " gear.";
    }
}
