package advanced.codelab05;

public class Author {
    private final String surName;
    private final String name;
    private final int age;
    private final Gender gender;

    public Author(String name, String surName, int age, Gender gender) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
    }

    public enum Gender {
        MALE, FEMALE
    }

    public int getAge() {
        return age;
    }

    public String getSurName() {
        return surName;
    }

    public Gender getGender() {
        return gender;
    }
}
