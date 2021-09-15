package basic.codelab03;

public enum Color {
    RED, BLUE, GREEN, YELLOW;

    @Override
    public String toString() {
        return name();
    }
}
