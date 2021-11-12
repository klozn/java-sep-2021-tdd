package basic.codelab03.be.switchfully.person;

import basic.codelab03.be.switchfully.address.Address;
import basic.codelab03.be.switchfully.book.Book;
import basic.codelab03.be.switchfully.hobby.Hobby;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "people")
public class Person {

    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "hobby_id", referencedColumnName = "id")
    private Hobby hobby;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private List<Book> books = new ArrayList<>();

    public Person() {

    }

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address.setResident(null);
        address.setResident(this);
        this.address = address;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("address=" + address + "'")
                .add("hobby=" + hobby + "'")
                .add("books=" + books)
                .toString();
    }
}
