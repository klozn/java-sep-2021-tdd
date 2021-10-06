package basic.codelab05;

import java.util.List;

public class Sum {

    public static int calculate(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

}
