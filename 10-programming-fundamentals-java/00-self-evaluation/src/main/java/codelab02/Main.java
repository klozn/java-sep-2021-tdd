package codelab02;

/**
 * Read the README.md for the assignment
 */
public class Main {

    public static char[] getAlphabet() {
        char[] alphabet = new char[26];
        for (int i = 0, j = 97; i < alphabet.length; i++, j++) {
            alphabet[i] = (char) j;
        }
        return alphabet;
    }

    public static String[] replace3thElement(String[] strings) {
        strings[2] = "do";
        return strings;
    }
}
