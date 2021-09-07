package advanced;

public class LoopsCodelabs09 {

    /**
     * Create a method that will return the n-th fibonacci number.
     * E.g.
     * fibonacci(1) = 1
     * fibonacci(2) = 1
     * fibonacci(3) = 2
     * fibonacci(4) = 3
     * fibonacci(5) = 5
     * fibonacci(6) = 8
     * ...
     * fibonacci(n) = fibonacci(n - 1) + fibonacci (n - 2)
     */
    public static int fibonacci(int number) {
        if (number < 1) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }

        int[] fibonacciSequence = new int[number];
        fibonacciSequence[0] = 1;
        fibonacciSequence[1] = 1;
        for (int i = 2; i < number; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 2] + fibonacciSequence[i - 1];
        }
        return fibonacciSequence[number - 1];
    }
}
