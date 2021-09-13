package advanced.codelab01;

public class Goat {
    private int age;
    private Health health;

    public Goat(int age, Health health) {
        setAge(age);
        this.health = health;
    }

    public void setAge(int age) {
        if (age > 1 && age < 11) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public Health getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return String.format("Goat - %d years old - doing %s", age, health);
    }
}
