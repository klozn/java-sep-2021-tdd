package codelab09.screens;

public class LCDScreen extends Screen {
    private int activeEnergyConsumption;
    private int idleEnergyConsumption;

    public LCDScreen(float sizeInInch, String resolution) {
        super(sizeInInch, resolution);
    }

    public LCDScreen(float sizeInInch, String resolution, int colorDepth, int pixelDepth) {
        super(sizeInInch, resolution, colorDepth, pixelDepth);
    }

    @Override
    public int getActiveEnergyConsumptionInKWH() {
        return activeEnergyConsumption;
    }

    @Override
    public int getIdleEnergyConsumptionInKWH() {
        return idleEnergyConsumption;
    }
}
