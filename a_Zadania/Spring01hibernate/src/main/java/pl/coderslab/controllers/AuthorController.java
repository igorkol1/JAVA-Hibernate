package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entities.Author;
import pl.coderslab.repositories.AuthorRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/create")
    public String createAuthorForm(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "authorForm";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute @Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "authorForm";
        }
        authorRepository.save(author);
        return "redirect:/authors/list";
    }

    @GetMapping("/list")
    public String authorList(){
        return "auhtorList";
    }

    @GetMapping("/edit/{id}")
    public String editAuthorForm(@PathVariable int id,Model model){
        Author author = authorRepository.findById((long) id).get();
        model.addAttribute("author",author);
        return "authorForm";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@ModelAttribute @Valid Author author,BindingResult result){
        if(result.hasErrors()){
            return "authorForm";
        }
        authorRepository.save(author);
        return "redirect:/authors/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthorQuestion(@PathVariable int id, Model model){
        Author author = authorRepository.findById((long) id).get();
        model.addAttribute("author",author);
        return "confirmationAuthor";
    }

    @GetMapping("/delete/{id}/yes")
    public String deleteBook(@PathVariable int id){
        Optional<Author> authorOptional = authorRepository.findById((long) id);
        authorOptional.ifPresent(author -> authorRepository.delete(author));
        return "redirect:/authors/list";
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

}
