package codelab07;

import java.util.StringJoiner;

public class StringConcat {

    public static void main(String[] args) {
        String[] lorem = {"Lorem","ipsum","dolor","sit","amet"};
        System.out.println(joinLorem(lorem));
        System.out.println(buildLorem(lorem));
    }

    /**
     * Implement the joinLorem method to make the test succeed.
     * Hints: Look up information on StringJoiner, then create an object and use it.
     */
    static String joinLorem(String[] wordsToJoin) {
        StringJoiner stringJoiner = new StringJoiner(" ", "", ".");
        for (String s: wordsToJoin) {
            stringJoiner.add(s);
        }
        return stringJoiner.toString();
    }

    /**
     * Implement the buildLorem method to make the test succeed.
     * Hints: Look up information on StringBuilder, then create an object and use it.
     */
    static String buildLorem(String[] wordsToBuild) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wordsToBuild.length - 1; i++) {
            stringBuilder.append(wordsToBuild[i]).append(" ");
        }
        stringBuilder.append(wordsToBuild[wordsToBuild.length - 1])
                .append(".");
        return stringBuilder.toString();
    }

}
