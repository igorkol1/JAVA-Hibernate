package pl.coderslab.daos;

import org.springframework.stereotype.Repository;
import pl.coderslab.entities.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Deprecated
@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher(Publisher entity) {
        entityManager.persist(entity);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Publisher> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM Publisher b");
        return query.getResultList();
    }
}
