package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entities.Category;
import pl.coderslab.repositories.ArticleRepository;
import pl.coderslab.repositories.CategoryRepository;

import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository,
                             CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list/{categoryId}")
    public String listForCategory(@PathVariable long categoryId, Model model){
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        optionalCategory.ifPresent(category->{
            model.addAttribute("categoryArticles",articleRepository.findAllByCategoriesContains(category));
        });
        return "listOfCategoryArticles";
    }

}
