package codelab01;

public class Alien {

    private String firstName;
    private String lastName;
    int numberOfHeads;

    public Alien() {
        this("Unidentified", "Unidentified");
    }

    public Alien(String firstName, String lastName) {
        this(firstName, lastName, 1);
    }

    public Alien(String firstName, String lastName, int numberOfHeads) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfHeads = numberOfHeads;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getNumberOfHeads() {
        return numberOfHeads;
    }
}
