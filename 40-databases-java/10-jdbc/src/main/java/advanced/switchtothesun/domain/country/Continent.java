package advanced.switchtothesun.domain.country;

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
        return name;
    }
}
