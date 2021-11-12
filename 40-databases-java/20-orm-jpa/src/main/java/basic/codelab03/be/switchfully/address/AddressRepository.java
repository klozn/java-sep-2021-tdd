package basic.codelab03.be.switchfully.address;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Address save(Address address) {
        entityManager.persist(address);
        return findById(address.getId());
    }

    public void remove(Address address) {
        entityManager.remove(entityManager.contains(address) ? address : entityManager.merge(address));
    }

    public Address findById(int addressId) {
        return entityManager.find(Address.class, addressId);
    }

    public List<Address> getAll() {
        return entityManager.createQuery("select a from Address a", Address.class)
                .getResultList();
    }
}
