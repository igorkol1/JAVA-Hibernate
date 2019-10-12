package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
