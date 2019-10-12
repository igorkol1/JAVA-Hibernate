package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entities.Author;
import pl.coderslab.entities.Book;
import pl.coderslab.entities.Category;
import pl.coderslab.entities.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>,
                                        BookCustomRepository{

    List<Book> findAllByPropositionTrue();

    List<Book> findAllByPropositionFalse();

    //****

    Book findBookByTitle(String title);

    Book findBookByCategory(Category category);

    Book findBookByCategoryId(long id);

    List<Book> findAllByAuthors(Author author);

    List<Book> findAllByPublisher(Publisher publisher);

    List<Book> findAllByRating(int rating);

    Book findFirstByCategoryOrderByTitle(Category category);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Book findBookWithTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.category.name = :categoryName")
    Book findBookWithCategory(@Param("categoryName") String categoryName);

    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN :minRating AND :maxRating")
    List<Book> findBookWithRatting(@Param("minRating") int min,@Param("maxRating") int max);

    @Query("SELECT b FROM Book b WHERE b.publisher.id= :publisherId")
    List<Book> findBookFromPublisher(@Param("publisherId") long publisherId);

    @Query("SELECT b FROM Book b WHERE b.category.name = :categoryName ORDER BY b.title")
    Book findBookWithCategoryAndOrderByTitle(@Param("categoryName") String categoryName);

}
