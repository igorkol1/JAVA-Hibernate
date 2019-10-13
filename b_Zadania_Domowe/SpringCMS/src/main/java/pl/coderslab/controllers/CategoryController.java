package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Category;
import pl.coderslab.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String getCatgoriesList() {
        return "categoryList";
    }

    @GetMapping("/create")
    public String getCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "categoryForm";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/edit/{categoryId}")
    public String getCategoryEditForm(@PathVariable long categoryId, Model model) {
        categoryRepository.findById(categoryId)
                .ifPresent(category -> model.addAttribute("category", category));
        return "categoryForm";
    }

    @PostMapping("/edit/{categoryId}")
    public String updateCategory(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable long categoryId) {
        categoryRepository.findById(categoryId)
                .ifPresent(category -> categoryRepository.delete(category));
        return "redirect:/category/list";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

}
