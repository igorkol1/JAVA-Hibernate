package pl.coderslab.daos;

import org.springframework.stereotype.Repository;
import pl.coderslab.entities.Book;
import pl.coderslab.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePerson(Person entity) {
        entityManager.persist(entity);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person entity) {
        entityManager.merge(entity);
    }

    public void delete(Person entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Person> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM Person b");
        return query.getResultList();
    }

}
