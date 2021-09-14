package codelab10;

public class Vehicle {
    private String type;
    private Integer passengers;
    private Integer wheels;
    private String motor;
    private Integer maxHeight;

    public Vehicle(int passengers, Integer wheels) {
        this.type = "Bike";
        this.passengers = passengers;
        this.wheels = wheels;
    }

    /**
     * This is an example of a static method factory. It replaces the above constructor.
     * The benefit is that with this pattern you can give your constructors a name.
     * Making it much clearer why and how you should use them.
     * Also, you can create 2 constructors this way who have the same signature.
     */
    public static Vehicle createBicycle(int passengers, Integer wheels) {
        return new Vehicle("Bike", passengers, wheels, null, null);
    }

    public static Vehicle createStep(String motor) {
        return new Vehicle("Step", 1, 2, motor, null);
    }

    public static Vehicle createCar(int passengers, String motor) {
        return new Vehicle("Car", passengers, 4, motor, null);
    }

    public static Vehicle createBalloon(int passengers, int maxHeight) {
        return new Vehicle("Balloon", passengers, null, null, maxHeight);
    }

    public static Vehicle createJet(int passengers, Integer wheels, String motor, int maxHeight) {
        return new Vehicle("Jet", passengers, wheels, motor, maxHeight);
    }

    public static Vehicle createBoat(int passengers, String motor) {
        return new Vehicle("Boat", passengers, null, motor, null);
    }

    /**
     * When working with static method factories it is a good practice to only have one private constructor.
     */
    private Vehicle(String type, Integer passengers, Integer wheels, String motor, Integer maxHeight) {
        this.type = type;
        this.passengers = passengers;
        this.wheels = wheels;
        this.motor = motor;
        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", passengers=" + passengers +
                ", wheels=" + wheels +
                ", motor='" + motor + '\'' +
                ", maxHeight=" + maxHeight +
                '}';
    }
}
