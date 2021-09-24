package codelab01;

public class FizzBuzzService {

    public String[] fizzBuzz(int x) {
        if (x <= 1) {
            throw new IllegalArgumentException("'X' can't be smaller than 2");
        }
        String[] result = new String[x];
        for (int i = 0; i < x; i++) {
            if ((i + 1) % 5 == 0 && (i + 1) % 3 == 0) {
                result[i] = "FizzBuzz";
            } else if ((i + 1) % 3 == 0) {
                result[i] = "Fizz";
            } else if ((i + 1) % 5 == 0) {
                result[i] = "Buzz";
            } else {
                result[i] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}
