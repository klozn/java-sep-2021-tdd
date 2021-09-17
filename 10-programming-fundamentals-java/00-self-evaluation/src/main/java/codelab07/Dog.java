package codelab07;

import java.util.Objects;

public abstract class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public abstract String bark();

    public abstract int getAverageBreedWeight();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("(name = '").append(name).append(", ");
        sb.append("sound = ").append(bark()).append(", ");
        sb.append("average breed weight = ").append(getAverageBreedWeight()).append(')');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) && bark().equals(dog.bark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
