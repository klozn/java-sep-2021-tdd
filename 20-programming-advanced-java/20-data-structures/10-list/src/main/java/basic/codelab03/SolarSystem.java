package basic.codelab03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolarSystem {
    private final List<String> planets = new ArrayList<>();

    boolean addPlanet(String planet) {
        return planets.add(planet);
    }

    void insertPlanet(int index, String planet) {
        planets.add(index, planet);
    }

    boolean removePlanet(String planet) {
        return planets.remove(planet);
    }

    void replacePlanet(int indexToReplace, String newPlanet) {
        planets.set(indexToReplace, newPlanet);
    }

    void swapPositions(int planetIndex1, int planetIndex2) {
        String planet1 = planets.set(planetIndex1, planets.get(planetIndex2));
        planets.set(planetIndex2, planet1);
    }

    void reversePlanetOrder() {
        Collections.reverse(planets);
    }

    void printPlanets() {
        StringBuilder sb = new StringBuilder("Planets:\n");
        int index = 0;
        for (String planet: planets) {
            sb.append(index++).append(": ");
            sb.append(planet).append('\n');
        }
        System.out.println(sb);
    }
}
