package basic.codelab03.be.switchfully.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book createNewBook(String title, String author) {
        return repository.save(new Book(title, author));
    }

    public List<Book> getAllBooks() {
        return repository.getAll();
    }

    public Book getBookById(int bookId) {
        return repository.findById(bookId);
    }

    public void removeAllBooksByTitleStartingWith(String startOfTitle) {
        repository.removeAllByTitleStartingWith(startOfTitle);
    }
}
