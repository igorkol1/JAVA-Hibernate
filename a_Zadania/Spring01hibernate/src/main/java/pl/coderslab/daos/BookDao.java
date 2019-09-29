package pl.coderslab.daos;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public Book findById(long id) {
        Book book = entityManager.find(Book.class, id);
        Hibernate.initialize(book.getPublisher());
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Book> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList();
        books.forEach(book -> {
            Hibernate.initialize(book.getPublisher());
            Hibernate.initialize(book.getAuthors());
        });
        return books;
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }
}
