package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Author;
import pl.coderslab.entities.Book;
import pl.coderslab.entities.Category;
import pl.coderslab.entities.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

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



}
