package basic.codelab03.be.switchfully.hobby;

import basic.codelab03.be.switchfully.person.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "hobby")
public class Hobby {
    @Id
    @SequenceGenerator(name = "hobby_seq", sequenceName = "HOBBY_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hobby_seq")
    private int id;
    private String name;
    private String type;

    public Hobby() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Hobby(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Hobby.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .toString();
    }
}
