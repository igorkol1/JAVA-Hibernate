package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
