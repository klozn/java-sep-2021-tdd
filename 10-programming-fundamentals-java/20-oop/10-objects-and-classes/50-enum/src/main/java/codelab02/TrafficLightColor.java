package codelab02;

public enum TrafficLightColor {
    RED("Red"),
    RNG("Orange"),
    GRN("Green");

    private String printName;

    TrafficLightColor(String printName) {
        this.printName = printName;
    }

    public TrafficLightColor next() {
        return switch (this) {
            case RED -> GRN;
            case GRN -> RNG;
            case RNG -> RED;
        };
    }

    public String getPrintName() {
        return printName;
    }
}
