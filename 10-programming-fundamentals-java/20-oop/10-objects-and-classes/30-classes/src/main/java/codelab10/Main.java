package codelab10;

public class Main {
    /**
     * The class Vehicle is a huge mess.
     * Use that static method factory pattern to clean up this code.
     * You can find an example of a static method factory in the Vehicle class.
     *
     * After you're done the Vehicle class should only have one private constructor.
     * All objects should be created by static method factories
     */
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[]{
                Vehicle.createBicycle(1,2),
                Vehicle.createStep("Electric"),
                Vehicle.createCar(4,"V8"),
                Vehicle.createBalloon(4, 5000),
                Vehicle.createJet(416, 2, "Turbo Jet", 10000),
                Vehicle.createBoat(1000, "Mercury Marine")
        };

        for (Vehicle vehicle: vehicles) {
            System.out.println(vehicle);
        }
    }
}
