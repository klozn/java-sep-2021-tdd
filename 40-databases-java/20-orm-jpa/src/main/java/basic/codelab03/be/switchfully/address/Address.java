package basic.codelab03.be.switchfully.address;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.StringJoiner;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "address_seq", sequenceName = "ADDRESS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private int id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "region")
    private String region;
    @Column(name = "zip_code")
    private int zipCode;

    public Address() {
    }

    public Address(String streetName, String houseNumber, String region, int zipCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.region = region;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("streetName='" + streetName + "'")
                .add("houseNumber='" + houseNumber + "'")
                .add("region='" + region + "'")
                .add("zipCode=" + zipCode)
                .toString();
    }
}
