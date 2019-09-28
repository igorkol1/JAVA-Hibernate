package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.daos.AuthorDao;
import pl.coderslab.daos.BookDao;
import pl.coderslab.daos.PublisherDao;
import pl.coderslab.entities.Author;
import pl.coderslab.entities.Book;
import pl.coderslab.entities.Publisher;
import pl.coderslab.utils.RandomString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

@Controller
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

    @GetMapping("/create-book")
    @ResponseBody
    public String createBook(){
        Book newBook = generateRandomBook();
        bookDao.saveBook(newBook);
        return newBook.toString();
    }

    @GetMapping("/get-book/{id}")
    @ResponseBody
    public String getBook(@PathVariable String id){
        Book book = bookDao.findById(Long.parseLong(id));
        if(book!=null){
            return book.toString();
        }else {
            return "Not found book with id "+id;
        }
    }

    @GetMapping("/edit-book/{id}")
    @ResponseBody
    public String updateBook(@PathVariable String id){
        Book book = bookDao.findById(Long.parseLong(id));
        if(book!=null){
            RandomString randomString = new RandomString(10);
            book.setTitle(randomString.nextString());
            book.setDescription(randomString.nextString());
            bookDao.update(book);
            return book.toString();
        }else {
            return "Not found book with id "+id;
        }
    }

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

    private Book generateRandomBook(){
        Random random = new Random();
        RandomString randomString = new RandomString(10,random);

        Book book = new Book();

        Publisher publisher = publisherDao.findById(1L);
        book.setPublisher(publisher);

        Author author = authorDao.findById(1L);
        book.setAuthors(Collections.singletonList(author));

        book.setDescription(randomString.nextString());
        book.setPublisher(publisher);
        book.setRating(random.nextInt(10));
        book.setTitle(randomString.nextString());
        return book;
    }

}
