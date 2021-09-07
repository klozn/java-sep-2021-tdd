package advanced;

public class LoopsCodelabs03 {

    /**
     * We'll say that a String is xy-balanced if for all the 'x' chars in the string,
     * there exists a 'y' char somewhere later in the string.
     * So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's.
     * Return true if the given string is xy-balanced.
     * Attention: if the given String is empty, it is xy-balanced!
     *      xyBalance("aaxbby") → true
     *      xyBalance("aaxbb") → false
     *      xyBalance("yaaxbb") → false
     *      xyBalance("") → true
     */
    public static boolean xyBalance(String textToAnalyze) {
        if (textToAnalyze.isEmpty()) {
            return true;
        }
        boolean balanced = true;
        char[] characters = textToAnalyze.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == 'x') {
                balanced = false;

                for (int j = i; !balanced && j < characters.length; j++) {
                    if (characters[j] == 'y') {
                        balanced = true;
                        i = j;
                    }
                }
            }
        }
        return balanced;
    }

}
