package advanced.codelab03;

public class Person {

    private final String name;
    private final int age;
    private final String nationality;

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }
}
