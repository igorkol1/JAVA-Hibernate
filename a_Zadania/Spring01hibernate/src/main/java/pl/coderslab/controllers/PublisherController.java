package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.daos.PublisherDao;
import pl.coderslab.entities.Publisher;
import pl.coderslab.utils.RandomString;

@Controller
public class PublisherController {

    private PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/create-publisher")
    @ResponseBody
    public String createAuthor(){
        Publisher newPublisher = generateRandomAuthor();
        publisherDao.savePublisher(newPublisher);
        return newPublisher.toString();
    }

    @GetMapping("/get-publisher/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable String id){
        Publisher publisher = publisherDao.findById(Long.parseLong(id));
        if(publisher!=null){
            return publisher.toString();
        }else {
            return "Not found publisher with id "+id;
        }
    }

    @GetMapping("/edit-publisher/{id}")
    @ResponseBody
    public String updateAuthor(@PathVariable String id){
        Publisher publisher = publisherDao.findById(Long.parseLong(id));
        if(publisher!=null){
            RandomString randomString = new RandomString(10);
            publisher.setName(randomString.nextString());
            publisherDao.update(publisher);
            return publisher.toString();
        }else {
            return "Not found publisher with id "+id;
        }
    }

    @GetMapping("/delete-publisher/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable String id){
        Publisher publisher = publisherDao.findById(Long.parseLong(id));
        if(publisher!=null){
            publisherDao.delete(publisher);
            return "Publisher deleted";
        }else {
            return "Not found publisher with id "+id;
        }
    }

    private Publisher generateRandomAuthor(){
        RandomString randomString = new RandomString(10);
        Publisher publisher = new Publisher(randomString.nextString());
        return publisher;
    }

}
