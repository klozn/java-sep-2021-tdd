package codelab06;

public class SlotMachineService {
    private final WordSlotMachine slotMachine = new WordSlotMachine();

    public String[] spinSlotMachine() {
        return slotMachine.spin();
    }

    public int numberOfMatches(String[] words) {
        if (words == null) {
            return 0;
        }
        if (words.length != 3) {
            throw new IllegalArgumentException("We need 3 words to check");
        }
        if (words[0].equals(words[1])) {
            if (words[0].equals(words[2])) {
                return 2;
            }
            return 1;
        }
        if (words[0].equals(words[2])) {
            return 1;
        }
        if (words[1].equals(words[2])) {
            return 1;
        }
        return 0;
    }

    public double calculateWinnings(double bet, int numberOfMatches) {
        return switch (numberOfMatches) {
            default -> 0;
            case 1 -> bet * 2;
            case 2 -> bet * 3;
        };
    }
}
