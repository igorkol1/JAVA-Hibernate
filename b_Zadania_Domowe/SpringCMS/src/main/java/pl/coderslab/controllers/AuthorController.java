package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Author;
import pl.coderslab.repositories.AuthorRepository;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/list")
    public String getAuthorsList() {
        return "authorList";
    }

    @GetMapping("/create")
    public String getCategoryForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authorForm";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/author/list";
    }

    @GetMapping("/edit/{id}")
    public String getCategoryEditForm(@PathVariable long id, Model model) {
        authorRepository.findById(id)
                .ifPresent(author -> model.addAttribute("author", author));
        return "authorForm";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/author/list";
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
}
