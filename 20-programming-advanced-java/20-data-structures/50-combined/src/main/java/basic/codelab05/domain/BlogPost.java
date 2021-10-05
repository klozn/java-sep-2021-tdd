package basic.codelab05.domain;

import java.time.LocalDateTime;
import java.util.*;

public class BlogPost implements Comparable<BlogPost> {
    private final Author author;
    private final String title;
    private final String body;
    private final Category category;
    private final LocalDateTime creationDateTime;

    public BlogPost(Author author, String title, String body, Category category) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.category = category;
        this.creationDateTime = LocalDateTime.now();
    }

    public Author getAuthor() {
        return author;
    }

    public Collection<String> getAllUniqueWordsFromBody() {
        String[] wordsInBody = body.split(" ");
        Set<String> uniqueWords = new HashSet<>();
        for (String word : wordsInBody) {
            word = word.toLowerCase(Locale.ROOT);
            word = word.replaceAll("[^A-Za-z0-9]", "");
            uniqueWords.add(word);
        }
        System.out.println(uniqueWords);
        return uniqueWords;
    }

    @Override
    public int compareTo(BlogPost other) {
        return creationDateTime.compareTo(other.creationDateTime);
    }
}
