package basic.codelab01;

public class PowerplantOperator {

    public static void main(String[] args) {
        NuclearPowerplant plant = new NuclearPowerplant();
        NuclearPowerplant secondPlant = new NuclearPowerplant();

        try {
            System.out.println(plant.increasePower(77));
        } catch (IllegalArgumentException ex) {
            System.err.println("Could not increase power: " + ex.getMessage());
        }

        try {
            System.out.println(secondPlant.increasePower(11));
        } catch (IllegalArgumentException ex) {
            System.err.println("Could not increase power: " + ex.getMessage());
        }

    }

}
