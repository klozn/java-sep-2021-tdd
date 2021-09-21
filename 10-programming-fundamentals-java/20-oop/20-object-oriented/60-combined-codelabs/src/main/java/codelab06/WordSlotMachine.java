package codelab06;

import java.util.Random;

public class WordSlotMachine {
    public static final String[] WORDS = new String[] {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
    public static final int NR_OF_WORDS = WORDS.length;
    private static final Random random = new Random();

    public String[] spin() {
        String[] result = new String[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = WORDS[random.nextInt(NR_OF_WORDS)];
        }
        return result;
    }
}
