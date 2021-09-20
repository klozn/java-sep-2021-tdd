package advanced;

public class RecursiveFunctionsCodelab03 {

    public static void main(String[] args) {
        System.out.println(pairStar("hello"));
    }

    /**
     * Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
     * e.g. pairStar("hello") → "hel*lo"
     * e.g. pairStar("xxyy") → "x*xy*y"
     * e.g. pairStar("aaaa") → "a*a*a*a"
     */
    public static String pairStar(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return pairStar(input.substring(0, i + 1) + "*" + input.substring(i+1));
            }
        }
        return input;
    }
}
