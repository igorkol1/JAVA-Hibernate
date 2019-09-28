package pl.coderslab.daos;

import org.springframework.stereotype.Repository;
import pl.coderslab.entities.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveDetailsPerson(PersonDetails entity) {
        entityManager.persist(entity);
    }

    public PersonDetails findById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void update(PersonDetails entity) {
        entityManager.merge(entity);
    }

    public void delete(PersonDetails entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<PersonDetails> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM PersonDetails b");
        return query.getResultList();
    }
}
