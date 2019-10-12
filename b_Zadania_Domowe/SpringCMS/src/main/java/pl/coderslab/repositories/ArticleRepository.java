package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Article;
import pl.coderslab.entities.Category;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findTop5ByOrderByCreatedDesc();

    List<Article> findAllByCategoriesContains(Category category);

}
