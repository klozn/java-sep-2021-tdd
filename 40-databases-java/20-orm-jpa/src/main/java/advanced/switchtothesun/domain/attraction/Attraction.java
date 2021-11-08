package advanced.switchtothesun.domain.attraction;

import advanced.switchtothesun.domain.country.Country;

public class Attraction {

    private String name;

    private Country country;

    public Attraction(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name + " - " + country;
    }
}
