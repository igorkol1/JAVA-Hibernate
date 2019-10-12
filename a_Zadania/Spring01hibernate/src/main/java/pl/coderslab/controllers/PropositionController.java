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
import pl.coderslab.validators.PropositionValidationGroup;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public PropositionController(BookRepository bookRepository,
                                 PublisherRepository publisherRepository,
                                 AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/list")
    public String bookList(Model model) {
        return "propositionsList";
    }

    @GetMapping("/create")
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute @Validated({PropositionValidationGroup.class}) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookForm";
        }
        book.setProposition(true);
        bookRepository.save(book);
        return "redirect:/proposition/list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        Book book = bookRepository.findById((long) id).get();
        model.addAttribute("book", book);
        return "bookForm";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute @Validated({PropositionValidationGroup.class}) Book book) {
        book.setProposition(true);
        bookRepository.save(book);
        return "redirect:/proposition/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookQuestion(@PathVariable int id, Model model) {
        Book book = bookRepository.findById((long) id).get();
        model.addAttribute("book", book);
        return "confirmation";
    }

    @GetMapping("/delete/{id}/yes")
    public String deleteBook(@PathVariable int id) {
        Optional<Book> bookOptional = bookRepository.findById((long) id);
        bookOptional.ifPresent(book -> bookRepository.delete(book));
        return "redirect:/proposition/list";
    }

    @ModelAttribute("propositions")
    public List<Book> getBookPropositions() {
        return bookRepository.findAllByPropositionTrue();
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    @ModelAttribute("authorsList")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

}
