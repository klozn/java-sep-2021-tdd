package advanced.codelab06;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class WordLengthReporter {

    public String reportAmountOfWordsPerWordLength(String sentence) {
        final StringJoiner sj = new StringJoiner(", ");

        final var stringsPerLength = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));
        stringsPerLength.keySet().stream()
                .sorted()
                .forEach(key -> sj.add(key + ":" + stringsPerLength.get(key).size()));
        return sj.toString();
    }
}
