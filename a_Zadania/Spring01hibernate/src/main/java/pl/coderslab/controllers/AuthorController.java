package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.daos.AuthorDao;
import pl.coderslab.entities.Author;
import pl.coderslab.utils.RandomString;

@Controller
public class AuthorController {

    private AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/create-author")
    @ResponseBody
    public String createAuthor(){
        Author newAuthor = generateRandomAuthor();
        authorDao.saveAuthor(newAuthor);
        return newAuthor.toString();
    }

    @GetMapping("/get-author/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable String id){
        Author author = authorDao.findById(Long.parseLong(id));
        if(author!=null){
            return author.toString();
        }else {
            return "Not found author with id "+id;
        }
    }

    @GetMapping("/edit-author/{id}")
    @ResponseBody
    public String updateAuthor(@PathVariable String id){
        Author author = authorDao.findById(Long.parseLong(id));
        if(author!=null){
            RandomString randomString = new RandomString(10);
            author.setFirstName(randomString.nextString());
            author.setLastName(randomString.nextString());
            authorDao.update(author);
            return author.toString();
        }else {
            return "Not found author with id "+id;
        }
    }

    @GetMapping("/delete-author/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable String id){
        Author author = authorDao.findById(Long.parseLong(id));
        if(author!=null){
            authorDao.delete(author);
            return "Author deleted";
        }else {
            return "Not found author with id "+id;
        }
    }

    private Author generateRandomAuthor(){
        RandomString randomString = new RandomString(10);
        Author author = new Author(randomString.nextString(),randomString.nextString());
        return author;
    }


}
