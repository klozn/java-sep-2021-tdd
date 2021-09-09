package codelab02;

public class RailroadCar {
    private String serialNumber;
    private boolean isFirstClass;
    private int numberOfSeats;
    private boolean hasToilet;

    public RailroadCar(String serialNumber) {
        this(serialNumber, false, 100, false);
    }

    public RailroadCar(String serialNumber, boolean isFirstClass, int numberOfSeats, boolean hasToilet) {
        this.serialNumber = serialNumber;
        this.isFirstClass = isFirstClass;
        this.numberOfSeats = numberOfSeats;
        this.hasToilet = hasToilet;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public void setFirstClass(boolean firstClass) {
        isFirstClass = firstClass;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean hasToilet() {
        return hasToilet;
    }

    public void toggleHasToilet() {
        hasToilet = !hasToilet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RailroadCar ");
        sb.append(serialNumber).append(": ");
        sb.append("Number of seats: ").append(numberOfSeats);
        sb.append(" - First class: ").append(isFirstClass);
        sb.append(" - Has a toilet: ").append(hasToilet);
        return sb.toString();
    }
}
