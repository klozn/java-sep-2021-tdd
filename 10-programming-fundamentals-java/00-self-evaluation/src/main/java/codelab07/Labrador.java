package codelab07;

public class Labrador extends Dog {
    private static final int AVERAGE_BREED_WEIGHT_IN_KG = 35;
    private static final String BARKING_SOUND = "WOOF WOOF!";

    public Labrador(String name) {
        super(name);
    }

    @Override
    public String bark() {
        return BARKING_SOUND;
    }

    @Override
    public int getAverageBreedWeight() {
        return AVERAGE_BREED_WEIGHT_IN_KG;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Labrador: ");
        sb.append(super.toString());
        return sb.toString();
    }
}
