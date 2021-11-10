package basic.codelab03.be.switchfully.address;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Embeddable
public class Address {

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
    public String toString(){
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
