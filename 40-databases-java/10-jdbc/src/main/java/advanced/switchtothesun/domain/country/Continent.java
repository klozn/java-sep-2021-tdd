package advanced.switchtothesun.domain.country;

import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Continent {
    private final int id;
    private String name;

    public Continent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
