package basic.codelab02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WordReader {

    public void printEveryWord(Collection<String> wordCollection) {
        wordCollection.forEach(System.out::print);
    }

    public List<String> capitalizeAll(Collection<String> wordCollection) {
        List<String> capitalized = new ArrayList<>();
        for(String word: wordCollection) {
            capitalized.add(word.toUpperCase());
        }
        return capitalized;
    }
}
