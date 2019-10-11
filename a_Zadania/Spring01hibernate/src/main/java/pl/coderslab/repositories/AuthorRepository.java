package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findAllByLastName(String lastName);

}
