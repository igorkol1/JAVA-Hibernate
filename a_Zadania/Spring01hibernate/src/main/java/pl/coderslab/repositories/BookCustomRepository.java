package pl.coderslab.repositories;

import pl.coderslab.entities.Book;

public interface BookCustomRepository {

    Book customFindById(Long id);

    void resetRating(int rating);

}
