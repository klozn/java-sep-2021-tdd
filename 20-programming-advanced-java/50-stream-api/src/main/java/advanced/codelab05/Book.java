package advanced.codelab05;

public class Book {
    private final String title;
    private final String content;
    private final Author author;

    public Book(String title, String content, Author author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }
}
