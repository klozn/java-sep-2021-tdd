package basic.codelab01;

public class CarApp {
    public static void main(String[] args) {
        Engine engine = new Engine(20); // 20 horse-power
        Driver driver = new Driver("James", 18); // name and age
        Passenger[] passengers = new Passenger[]{new Passenger("Ann")};

        Car myCar = new Car(engine, driver, passengers);
        System.out.println(myCar);
    }
}
