package pl.coderslab.repositories;

import pl.coderslab.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class BookRepositoryImpl implements BookCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book customFindById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void resetRating(int rating) {
        Query query = entityManager.createQuery("UPDATE Book b SET b.rating= :rating");
        query.setParameter("rating", rating);
        query.executeUpdate();
    }

}
