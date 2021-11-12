package basic.codelab03.be.switchfully.hobby;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HobbyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public int save(Hobby hobby) {
        entityManager.persist(hobby);
        return hobby.getId();
    }

    public Hobby findById(int hobbyId) {
        return entityManager.find(Hobby.class, hobbyId);
    }
}
