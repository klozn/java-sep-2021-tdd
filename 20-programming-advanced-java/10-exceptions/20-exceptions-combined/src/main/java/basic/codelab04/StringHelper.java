package basic.codelab04;

public class StringHelper {
    public static void main(String[] args) {
        StringHelper.repeatArray(new String[]{"Beep"}, -1);
    }

    public static String repeatArray(String[] strings, int count) {
        if (strings == null) {
            throw new IllegalArgumentException("The string array provided is null.");
        }
        if (count < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string.repeat(count));
        }
        return sb.toString();
    }

}
