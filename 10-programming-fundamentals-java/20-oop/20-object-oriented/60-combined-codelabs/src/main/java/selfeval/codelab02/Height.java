package selfeval.codelab02;

import java.util.Objects;

public final class Height {
    public static final double AMOUNT_OF_FEET_IN_A_METER = 3.2808399;
    private final double heightAmount;
    private final HeightUnit unit;

    public Height(double heightAmount, HeightUnit unit) {
        this.heightAmount = heightAmount;
        this.unit = unit;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Height) obj;
        return Double.doubleToLongBits(this.heightAmount) == Double.doubleToLongBits(that.heightAmount) &&
                Objects.equals(this.unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heightAmount, unit);
    }
}
