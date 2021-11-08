package basic.codelab01.be.switchfully.country;

import basic.codelab01.be.switchfully.region.Region;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Country {
    private final String id;
    private String countryName;
    private Region region;

    public Country(String id, String countryName, Region region) {
        this.id = id;
        this.countryName = countryName;
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public boolean equals(Object other){
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
