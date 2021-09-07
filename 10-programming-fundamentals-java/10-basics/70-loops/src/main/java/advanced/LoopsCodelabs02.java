package advanced;

public class LoopsCodelabs02 {

    /**
     * Return true if the string "cat" and "dog" appear the same number of times in the given string.
     *      catDog("catdog") → true
     *      catDog("catcat") → false
     *      catDog("1cat1cadodog") → true
     * Tip: "cat" and "dog" both have length 3...
     */
    public static boolean catDog(String textToAnalyze) {
        if (textToAnalyze.isEmpty()) {
            return false;
        }

        char[] characters = textToAnalyze.toCharArray();
        int nrOfCats = 0;
        int nrOfDogs = 0;

        for (int i = 0; i < textToAnalyze.length(); i++) {
            if (characters[i] == 'c' && characters[i + 1] == 'a' && characters[i + 2] == 't') {
                nrOfCats++;
            }
            if (characters[i] == 'd' && characters[i + 1] == 'o' && characters[i + 2] == 'g') {
                nrOfDogs++;
            }
        }
        return nrOfCats == nrOfDogs;
    }
}
