package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.daos.AuthorDao;
import pl.coderslab.entities.Author;
import pl.coderslab.utils.RandomString;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/create")
    public String createAuthorForm(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "authorForm";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute Author author){
        authorDao.saveAuthor(author);
        return "redirect:/authors/list";
    }

    @GetMapping("/list")
    public String authorList(){
        return "auhtorList";
    }

    @GetMapping("/edit/{id}")
    public String editAuthorForm(@PathVariable int id,Model model){
        Author author = authorDao.findById(id);
        model.addAttribute("author",author);
        return "authorForm";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@ModelAttribute Author author){
        authorDao.update(author);
        return "redirect:/authors/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthorQuestion(@PathVariable int id, Model model){
        Author author = authorDao.findById(id);
        model.addAttribute("author",author);
        return "confirmationAuthor";
    }

    @GetMapping("/delete/{id}/yes")
    public String deleteBook(@PathVariable int id){
        Author author = authorDao.findById(id);
        if(author!=null) {
            authorDao.delete(author);
        }
        return "redirect:/authors/list";
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors(){
        return authorDao.getAll();
    }

}
