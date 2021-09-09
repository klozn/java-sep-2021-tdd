package codelab03;

public class Person {

    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public int calculateAllowance() {
        if (age < 13) {
            return 100;
        }
        if (age < 18) {
            return 100 + 5 * (age - 12);
        }
        return 0;
    }

}
