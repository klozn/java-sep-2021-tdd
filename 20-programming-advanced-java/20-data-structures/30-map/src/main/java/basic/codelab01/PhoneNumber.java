package basic.codelab01;

import java.util.Objects;

public class PhoneNumber {
    private final String countryCode;
    private final String numberItSelf;

    public PhoneNumber(String countryCode, String numberItSelf) {
        this.countryCode = countryCode;
        this.numberItSelf = numberItSelf;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNumberItSelf() {
        return numberItSelf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(numberItSelf, that.numberItSelf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, numberItSelf);
    }
}
