package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entities.Article;
import pl.coderslab.entities.Category;
import pl.coderslab.repositories.ArticleRepository;
import pl.coderslab.repositories.CategoryRepository;

import java.util.List;

@Controller
public class HomeController {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public HomeController(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String HomePage(){
        return "home";
    }

    @ModelAttribute("lastArticles")
    public List<Article> getLastArticles(){
        return articleRepository.findTop5ByOrderByCreatedDesc();
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

}
