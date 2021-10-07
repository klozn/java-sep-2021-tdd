package advanced.selfeval.codelab01.soldiers;

import java.util.Locale;

public enum Rank {
    PRIVATE_FIRST_CLASS,
    CORPORAL,
    SERGEANT,
    LIEUTENANT,
    CAPTAIN,
    MAJOR,
    COLONEL,
    GENERAL;

    public String getReadFriendlyLabel() {
        String label = this.name().toLowerCase(Locale.ROOT);
        label = label.replaceAll("_", " ");
        char firstChar = label.charAt(0);
        label = label.replace(firstChar, (char)(firstChar - 32));
        return label;
    }

    public Rank next() {
        return switch (this) {
            case PRIVATE_FIRST_CLASS -> CORPORAL;
            case CORPORAL -> SERGEANT;
            case SERGEANT -> LIEUTENANT;
            case LIEUTENANT -> CAPTAIN;
            case CAPTAIN -> MAJOR;
            case MAJOR -> COLONEL;
            case COLONEL, GENERAL -> GENERAL;
        };
    }
}
