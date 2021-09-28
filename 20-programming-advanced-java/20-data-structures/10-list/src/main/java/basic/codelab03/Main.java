package basic.codelab03;

public class Main {
    public static void main(String[] args) {
        SolarSystem solarSystem = new SolarSystem();
        solarSystem.addPlanet("Mars");
        solarSystem.addPlanet("Jupiter");
        solarSystem.insertPlanet(0, "Venus");
        solarSystem.addPlanet("Earth");
        solarSystem.addPlanet("Earth");
        solarSystem.printPlanets();
        solarSystem.removePlanet("Earth");
        solarSystem.swapPositions(1, 3);
        solarSystem.replacePlanet(0, "Mercury");
        solarSystem.printPlanets();
        solarSystem.reversePlanetOrder();
        solarSystem.printPlanets();
    }
}
