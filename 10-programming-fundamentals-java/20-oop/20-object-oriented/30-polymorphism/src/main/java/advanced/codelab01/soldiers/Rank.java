package advanced.codelab01.soldiers;

public enum Rank {
    PRIVATE_FIRST_CLASS(0),
    CORPORAL(1),
    SERGEANT( 2),
    LIEUTENANT(3),
    CAPTAIN(4),
    MAJOR(5),
    COLONEL(6),
    GENERAL(7);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public String getReadFriendlyLabel() {
        String label = this.name().toLowerCase();
        label = label.replaceAll("_", " ");
        return label.replace(Character.toString(label.charAt(0)),
                Character.toString(label.charAt(0)).toUpperCase());
    }

    public int getValue() {
        return value;
    }
}
