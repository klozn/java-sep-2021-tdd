package solutions.codelab11.food;

public class Food {

    private final String name;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
