package basic.codelab01;

public class Car {
    private Engine engine;
    private Driver driver;
    Passenger[] passengers;

    public Car(Engine engine, Driver driver, Passenger[] passengers) {
        this.engine = engine;
        this.driver = driver;
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("I am a car with ").append(passengers.length);
        sb.append(" passenger(s) ");
        for (Passenger passenger: passengers) {
            sb.append(passenger);
        }
        sb.append(", a driver called ").append(driver.getName());
        sb.append(" of ").append(driver.getAge()).append(" years old\n");
        sb.append("and an engine with ").append(engine.getHorsePower()).append(" horse-power");
        return sb.toString();
    }
}
