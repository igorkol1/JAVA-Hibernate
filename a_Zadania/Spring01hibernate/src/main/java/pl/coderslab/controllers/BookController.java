package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.daos.AuthorDao;
import pl.coderslab.daos.BookDao;
import pl.coderslab.daos.PublisherDao;
import pl.coderslab.entities.Author;
import pl.coderslab.entities.Book;
import pl.coderslab.entities.Publisher;
import pl.coderslab.utils.RandomString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    @Autowired
    public BookController(BookDao bookDao,
                          PublisherDao publisherDao,
                          AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/create")
    public String createBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book){
        bookDao.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String bookList(Model model){
        return "bookList";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id,Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book",book);
        return "bookForm";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute Book book){
        bookDao.update(book);
        return "redirect:/book/list";
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
        return "redirect:/book/list";
    }

    @ModelAttribute("books")
    public List<Book> getBooks(){
        return bookDao.getAll();
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers(){
        return publisherDao.getAll();
    }

    @ModelAttribute("authorsList")
    public List<Author> getAuthors(){
        return authorDao.getAll();
    }

    /*******************************************/

    @GetMapping("/delete-book/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable String id){
        Book book = bookDao.findById(Long.parseLong(id));
        if(book!=null){
            bookDao.delete(book);
            return "Book deleted";
        }else {
            return "Not found book with id "+id;
        }
    }



}
