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
import pl.coderslab.entities.Publisher;
import pl.coderslab.repositories.PublisherRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
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
        publisherRepository.save(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/edit/{id}")
    public String editAuthorForm(@PathVariable int id,Model model){
        Publisher publisher = publisherRepository.findById((long) id).get();
        model.addAttribute("publisher",publisher);
        return "publisherForm";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@ModelAttribute @Valid Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "publisherForm";
        }
        publisherRepository.save(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisherQuestion(@PathVariable int id, Model model){
        Publisher publisher = publisherRepository.findById((long) id).get();
        model.addAttribute("publisher",publisher);
        return "confirmationPublisher";
    }

    @GetMapping("/delete/{id}/yes")
    public String deleteBook(@PathVariable int id){
        Optional<Publisher> publisherOptional = publisherRepository.findById((long) id);
        publisherOptional.ifPresent(publisher -> publisherRepository.delete(publisher));
        return "redirect:/publisher/list";
    }


    @ModelAttribute("publishers")
    public List<Publisher> getAuthors(){
        return publisherRepository.findAll();
    }

}
