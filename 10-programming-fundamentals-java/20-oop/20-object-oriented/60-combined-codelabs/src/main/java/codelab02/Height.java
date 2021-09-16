package codelab02;

public record Height(double heightAmount, HeightUnit unit) {
    public static final double AMOUNT_OF_FEET_IN_A_METER = 3.2808399;

    public double getHeightAmount() {
        return heightAmount;
    }

    public HeightUnit getUnit() {
        return unit;
    }

    public static Height convertMetersToHeightInFoot(double meters) {
        return new Height(meters * AMOUNT_OF_FEET_IN_A_METER, HeightUnit.FOOT);
    }

    public static Height convertFeetToHeightInMeters(double feet) {
        return new Height(feet / AMOUNT_OF_FEET_IN_A_METER, HeightUnit.METER);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", heightAmount, unit.toString().toLowerCase());
    }

    // this being a record, equals and hashcode are generated automatically
/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return Double.compare(height.heightAmount, heightAmount) == 0 && unit == height.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heightAmount, unit);
    }*/
}
