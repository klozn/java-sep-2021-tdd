package advanced.codelab01.domain;

public class Price {
    private final double decimal;
    private final Currency currency;

    public Price(double decimal, Currency currency) {
        this.decimal = decimal;
        this.currency = currency;
    }

    public double getDecimal() {
        return decimal;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Price{");
        sb.append("decimal=").append(decimal);
        sb.append(", currency=").append(currency);
        sb.append('}');
        return sb.toString();
    }
}
