package basic.codelab02.be.switchfully.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    public List<Person> findByName(Name name) {
        return entityManager.createQuery("select p from Person p where p.name = :name", Person.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Person> getAll() {
        return entityManager.createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    public Person findById(String uuid) {
        return entityManager.find(Person.class, uuid);
    }

    public void remove(Person person) {
        entityManager.remove(person);
    }
}
