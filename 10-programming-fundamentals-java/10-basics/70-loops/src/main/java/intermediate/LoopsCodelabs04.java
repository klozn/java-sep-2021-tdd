package intermediate;

/**
 * Return a String containing x times (numberOfTimes) the provided String (textToRepeat)
 * numberOfTimes should be a positive number, if not, return text "Impossible text repeat"
 *      textRepeatWhile(2, "M") → "MM"
 *      textRepeatWhile(5, "Pew") → "PewPewPewPewPew"
 *      textRepeatWhile(0, "Hello") → ""
 *      textRepeatWhile(-1, "Non") → "Impossible text repeat"
 * In total, you'll have to implement this for 3 different methods,
 * each time using a different loop mechanism.
 */
public class LoopsCodelabs04 {

    /**
     * For this method, only use the WHILE-LOOP
     */
    public static String textRepeatWhile(int numberOfTimes, String textToRepeat) {
        if (!isPositive(numberOfTimes)) {
            return "Impossible text repeat";
        }
        String result = "";
        int counter = 0;
        while (counter < numberOfTimes) {
            result = result.concat(textToRepeat);
            counter++;
        }
        return result;
    }

    /**
     * For this method, only use the DO-WHILE-LOOP
     */
    public static String textRepeatDoWhile(int numberOfTimes, String textToRepeat) {
        if (!isPositive(numberOfTimes)) {
            return "Impossible text repeat";
        }
        if (numberOfTimes == 0) {
            return "";
        }

        String result = "";
        int counter = 0;
        do {
            result = result.concat(textToRepeat);
            counter++;
        } while (counter < numberOfTimes);
        return result;
    }

    /**
     * For this method, only use the FOR-LOOP
     */
    public static String textRepeatFor(int numberOfTimes, String textToRepeat) {
        if (!isPositive(numberOfTimes)) {
            return "Impossible text repeat";
        }
        String result = "";
        for (int i = 0; i < numberOfTimes; i++) {
            result = result.concat(textToRepeat);
        }
        return result;
    }

    private static boolean isPositive(int numberOfTimes) {
        return numberOfTimes >= 0;
    }

}
