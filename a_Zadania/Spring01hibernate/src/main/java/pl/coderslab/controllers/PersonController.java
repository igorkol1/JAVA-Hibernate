package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.daos.PersonDao;
import pl.coderslab.daos.PersonDetailsDao;
import pl.coderslab.entities.Person;
import pl.coderslab.entities.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonDao personDao;
    private PersonDetailsDao personDetailsDao;

    @Autowired
    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/create")
    public String createPersonFrom(Model model){
        Person person = new Person();
        model.addAttribute("person",person);
        return "personForm";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPerson(@ModelAttribute Person person){
        PersonDetails personDetails = new PersonDetails();
        personDetailsDao.saveDetailsPerson(personDetails);
        person.setPersonDetails(personDetails);
        personDao.savePerson(person);
        return "Person created: "+person.toString();
    }
}
