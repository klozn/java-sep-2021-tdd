package codelab09.screens;

import codelab09.EnergyConsumer;

public abstract class Screen implements EnergyConsumer {
    private final float sizeInInch;
    private final String resolution;
    private int brightness;
    private final int colorDepth;
    private final int pixelDepth;

    private int activeEnergyConsumption;
    private int idleEnergyConsumption;

    public Screen(float sizeInInch, String resolution) {
        this(sizeInInch, resolution, 16, 24);
    }

    public Screen(float sizeInInch, String resolution, int colorDepth, int pixelDepth) {
        this.sizeInInch = sizeInInch;
        this.resolution = resolution;
        this.colorDepth = colorDepth;
        this.pixelDepth = pixelDepth;
        setBrightness(10);
    }

    protected void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 10) {
            this.brightness = brightness;
        }
    }

    public void dim() {
        setBrightness(brightness - 1);
    }

    public void brighten() {
        setBrightness(brightness + 1);
    }

    @Override
    public int getActiveEnergyConsumptionInKWH() {
        return activeEnergyConsumption;
    }

    @Override
    public int getIdleEnergyConsumptionInKWH() {
        return idleEnergyConsumption;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Screen{");
        sb.append("sizeInInch=").append(sizeInInch);
        sb.append(", resolution='").append(resolution).append('\'');
        sb.append(", brightness=").append(brightness);
        sb.append(", colorDepth=").append(colorDepth);
        sb.append(", pixelDepth=").append(pixelDepth);
        sb.append('}');
        return sb.toString();
    }
}
