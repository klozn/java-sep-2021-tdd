package advanced.codelab01;

public class MountainGoat extends Goat {
    public MountainGoat(int age, Health health) {
        super(age, health);
    }

    @Override
    public void setAge(int age) {
        if (age < 9) {
            super.setAge(age);
        }
    }

    public void climb() {
        System.out.println("Climbing a rock...");
    }
}
