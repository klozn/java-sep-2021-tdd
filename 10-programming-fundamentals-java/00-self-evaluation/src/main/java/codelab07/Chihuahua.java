package codelab07;

public class Chihuahua extends Dog {
    private static final int AVERAGE_BREED_WEIGHT_IN_KG = 2;
    private static final String BARKING_SOUND = "Kefkefkef!";

    private final ChihuahuaColor color;

    public Chihuahua(String name, ChihuahuaColor color) {
        super(name);
        this.color = color;
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
        final StringBuilder sb = new StringBuilder("Chihuahua: ");
        sb.append(super.toString().replace(')', ','));
        sb.append(" color = ").append(color.getPrintName());
        sb.append(')');
        return sb.toString();
    }
}
