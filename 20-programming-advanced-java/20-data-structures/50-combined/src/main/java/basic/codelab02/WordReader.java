package basic.codelab02;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WordReader {

    public void printEveryWord(Collection<String> wordCollection) {
        wordCollection.forEach(System.out::print);
    }

    public List<String> capitalizeAll(Collection<String> wordCollection) {
        return wordCollection.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
