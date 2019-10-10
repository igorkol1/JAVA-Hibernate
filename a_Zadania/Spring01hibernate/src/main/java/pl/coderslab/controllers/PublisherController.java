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
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.daos.PublisherDao;
import pl.coderslab.entities.Author;
import pl.coderslab.entities.Publisher;
import pl.coderslab.utils.RandomString;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/list")
    public String authorList(){
        return "publisherList";
    }

    @GetMapping("/create")
    public String createAuthorForm(Model model){
        Publisher publisher = new Publisher();
        model.addAttribute("publisher",publisher);
        return "publisherForm";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute @Valid Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "publisherForm";
        }
        publisherDao.savePublisher(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/edit/{id}")
    public String editAuthorForm(@PathVariable int id,Model model){
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher",publisher);
        return "publisherForm";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@ModelAttribute @Valid Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "publisherForm";
        }
        publisherDao.update(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisherQuestion(@PathVariable int id, Model model){
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher",publisher);
        return "confirmationPublisher";
    }

    @GetMapping("/delete/{id}/yes")
    public String deleteBook(@PathVariable int id){
        Publisher publisher = publisherDao.findById(id);
        if(publisher!=null) {
            publisherDao.delete(publisher);
        }
        return "redirect:/publisher/list";
    }


    @ModelAttribute("publishers")
    public List<Publisher> getAuthors(){
        return publisherDao.getAll();
    }

}
