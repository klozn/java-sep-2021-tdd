package codelab01;

public class Human {
    private String firstName;
    private String lastName;
    private Gender gender;

    public Human(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s has gender %s", firstName, lastName, gender);
    }
}
