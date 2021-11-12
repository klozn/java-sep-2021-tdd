package basic.codelab03.be.switchfully.book;

import org.hibernate.criterion.CriteriaQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Locale;

@Repository
public class BookRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Book save(Book book) {
        entityManager.persist(book);
        return entityManager.find(Book.class, book.getId());
    }


    public Book findById(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    public List<Book> getAll() {
        return entityManager.createQuery("select b from Book b", Book.class)
                .getResultList();
    }

    public void removeAllByTitleStartingWith(String startOfTitle) {
        List<Book> toRemove = entityManager.createQuery(
                "select b from Book b where lower(b.title) like :title", Book.class)
                .setParameter("title", startOfTitle.toLowerCase(Locale.ROOT) + "%")
                .getResultList();
        toRemove.forEach(entityManager::remove);
    }
}
