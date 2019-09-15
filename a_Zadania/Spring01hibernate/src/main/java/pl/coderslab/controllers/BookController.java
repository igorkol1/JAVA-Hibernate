package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.daos.BookDao;
import pl.coderslab.entities.Book;
import pl.coderslab.utils.RandomString;

import java.util.Random;

@Controller
public class BookController {

    private BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
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
            book.setAuthor(randomString.nextString());
            book.setDescription(randomString.nextString());
            book.setPublisher(randomString.nextString());
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
        book.setAuthor(randomString.nextString());
        book.setDescription(randomString.nextString());
        book.setPublisher(randomString.nextString());
        book.setRating(random.nextInt(10));
        book.setTitle(randomString.nextString());
        return book;
    }

}
