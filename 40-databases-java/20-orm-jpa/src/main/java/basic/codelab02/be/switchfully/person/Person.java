package basic.codelab02.be.switchfully.person;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private String id;
    @Embedded
    private Name name;
    @Column(name = "favorite_color")
    private String favoriteColor;

    public Person() {
    }

    public Person(Name name, String favoriteColor) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.favoriteColor = favoriteColor;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " " + name + ", favourite color: " + favoriteColor;
    }
}
