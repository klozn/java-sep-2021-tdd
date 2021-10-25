package advanced.codelab05;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age && Objects.equals(surName, author.surName) && Objects.equals(name, author.name) && gender == author.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surName, name, age, gender);
    }
}
