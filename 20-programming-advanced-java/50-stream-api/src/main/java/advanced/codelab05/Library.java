package advanced.codelab05;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<String> get15OrLessUniqueSurnamesOf50YearOrOlderAuthorsOfBooks() {
        return books.stream()
                .map(Book::getAuthor)
                .filter(author -> author.getAge() >= 50)
                .map(Author::getSurName)
                .distinct()
                .limit(15)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public int getSumOfAgesOfAllFemaleAuthorsYoungerThan25() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .filter(author -> author.getGender().equals(Author.Gender.FEMALE))
                .map(Author::getAge)
                .filter(age -> age < 25)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public Map<Author, List<Book>> getBooksGroupedByAuthor() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.toList()));
    }
}
