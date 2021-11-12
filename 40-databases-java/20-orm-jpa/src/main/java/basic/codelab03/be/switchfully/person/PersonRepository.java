package basic.codelab03.be.switchfully.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person save(Person person){
        entityManager.persist(person.getAddress());
        entityManager.persist(person);
        return entityManager.find(Person.class, person.getId());
    }

    public void remove(Person person) {
        entityManager.remove(person);
    }

    public Person findByName(String firstName, String lastName){
        return entityManager.createQuery("select p from Person p " +
                        "where p.lastName = :lastName " +
                        "and p.firstName = :firstName", Person.class)
                    .setParameter("lastName", lastName)
                    .setParameter("firstName", firstName)
                    .getSingleResult();
    }

    public Person findById(int personId) {
        return entityManager.find(Person.class, personId);
    }
}
