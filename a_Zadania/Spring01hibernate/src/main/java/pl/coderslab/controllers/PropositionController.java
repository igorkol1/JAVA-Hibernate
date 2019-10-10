package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.daos.AuthorDao;
import pl.coderslab.daos.BookDao;
import pl.coderslab.daos.PublisherDao;
import pl.coderslab.entities.Author;
import pl.coderslab.entities.Book;
import pl.coderslab.entities.Publisher;
import pl.coderslab.validators.PropositionValidationGroup;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    @Autowired
    public PropositionController(BookDao bookDao,
                                 PublisherDao publisherDao,
                                 AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String bookList(Model model){
        return "propositionsList";
    }

    @GetMapping("/create")
    public String createBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute @Validated({PropositionValidationGroup.class}) Book book, BindingResult result){
        if(result.hasErrors()){
            return "bookForm";
        }
        book.setProposition(true);
        bookDao.saveBook(book);
        return "redirect:/proposition/list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book",book);
        return "bookForm";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute @Validated({PropositionValidationGroup.class}) Book book){
        book.setProposition(true);
        bookDao.update(book);
        return "redirect:/proposition/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookQuestion(@PathVariable int id, Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book",book);
        return "confirmation";
    }

    @GetMapping("/delete/{id}/yes")
    public String deleteBook(@PathVariable int id){
        Book book = bookDao.findById(id);
        if(book!=null) {
            bookDao.delete(book);
        }
        return "redirect:/proposition/list";
    }

    @ModelAttribute("propositions")
    public List<Book> getBookPropositions(){
        return bookDao.getAllBookPropositions();
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers(){
        return publisherDao.getAll();
    }

    @ModelAttribute("authorsList")
    public List<Author> getAuthors(){
        return authorDao.getAll();
    }

}
