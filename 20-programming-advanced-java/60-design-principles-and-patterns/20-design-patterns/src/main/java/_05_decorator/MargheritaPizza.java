package _05_decorator;

public class MargheritaPizza implements Pizza {

    private final String description;

    public MargheritaPizza() {
        description = "A basic margherita pizza";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 8.95;
    }
}
