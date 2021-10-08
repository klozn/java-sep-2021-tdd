package basic.codelab05.domain;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BlogPost implements Comparable<BlogPost> {
    private final Author author;
    private final String title;
    private final String body;
    private final Category category;
    private final LocalDate creationDate;

    public BlogPost(Author author, String title, String body, Category category, LocalDate creationDate) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.category = category;
        this.creationDate = creationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public Collection<String> getAllUniqueWordsFromBody() {
        return Arrays.stream(body.split(" "))
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[^a-z0-9]", ""))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(BlogPost other) {
        return -creationDate.compareTo(other.creationDate);
    }
}
