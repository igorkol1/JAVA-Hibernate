package pl.coderslab.daos;

import org.springframework.stereotype.Repository;
import pl.coderslab.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author entity) {
        entityManager.persist(entity);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Author> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM Author b");
        return query.getResultList();
    }

}
