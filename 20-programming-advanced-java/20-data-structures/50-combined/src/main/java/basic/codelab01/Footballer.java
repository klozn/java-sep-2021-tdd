package basic.codelab01;

import java.time.LocalDate;
import java.util.Objects;

public class Footballer implements Comparable<Footballer> {
    private final String name;
    private final LocalDate birthday;
    private String shirtNr;
    private int goalsScored;
    private Position position;

    public Footballer(String name, LocalDate birthday) {
        this(name, birthday, "0", Position.GOALKEEPER);
    }

    public Footballer(String name, LocalDate birthday, String shirtNr, Position position) {
        this.name = name;
        this.birthday = birthday;
        this.shirtNr = shirtNr;
        this.position = position;
    }

    public String getShirtNr() {
        return shirtNr;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Footballer o) {
        return -birthday.compareTo(o.birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footballer that = (Footballer) o;
        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Footballer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", shirtNr='").append(shirtNr).append('\'');
        sb.append(", position=").append(position);
        sb.append('}');
        return sb.toString();
    }
}
