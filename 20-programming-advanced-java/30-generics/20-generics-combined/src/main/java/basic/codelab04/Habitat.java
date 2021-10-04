package basic.codelab04;

import java.util.ArrayList;
import java.util.List;

public abstract class Habitat<T extends Animal> {

    private final List<T> inhabitants = new ArrayList<>();

    public void addInhabitant(T animal) {
        inhabitants.add(animal);
    }

    public List<T> getInhabitants() {
        return inhabitants;
    }
}
