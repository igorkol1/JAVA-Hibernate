package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entities.Author;
import pl.coderslab.entities.Book;
import pl.coderslab.entities.Publisher;
import pl.coderslab.repositories.AuthorRepository;
import pl.coderslab.repositories.BookRepository;
import pl.coderslab.repositories.PublisherRepository;
import pl.coderslab.validators.BookValidationGroup;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    @Autowired
    public BookController(PublisherRepository publisherRepository,
                          AuthorRepository authorRepository,
                          BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/create")
    public String createBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute @Validated({BookValidationGroup.class}) Book book, BindingResult result){
        if(result.hasErrors()){
            return "bookForm";
        }
        book.setProposition(false);
        bookRepository.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String bookList(Model model){
        return "bookList";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id,Model model){
        Book book = bookRepository.findOne(Long.valueOf(id));
        model.addAttribute("book",book);
        return "bookForm";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute @Validated({BookValidationGroup.class}) Book book){
        bookRepository.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookQuestion(@PathVariable int id, Model model){
        Book book = bookRepository.findOne(Long.valueOf(id));
        model.addAttribute("book",book);
        return "confirmation";
    }

    @GetMapping("/delete/{id}/yes")
    public String deleteBook(@PathVariable int id){
        Book book = bookRepository.findOne(Long.valueOf(id));
        if(book!=null) {
            bookRepository.delete(book);
        }
        return "redirect:/book/list";
    }

    @ModelAttribute("books")
    public List<Book> getBooks(){
        return bookRepository.findAllByPropositionFalse();
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers(){
        return publisherRepository.findAll();
    }

    @ModelAttribute("authorsList")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

}
