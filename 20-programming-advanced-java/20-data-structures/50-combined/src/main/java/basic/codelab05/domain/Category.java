package basic.codelab05.domain;

public enum Category {
    FUNNY("Funny"),
    DIY("DIY"),
    BEAUTY("Beauty"),
    GAMING("Gaming"),
    MOVIES("Movies"),
    SERIES("Series");

    private final String printValue;

    Category(String printValue) {
        this.printValue = printValue;
    }

    @Override
    public String toString() {
        return printValue;
    }
}
