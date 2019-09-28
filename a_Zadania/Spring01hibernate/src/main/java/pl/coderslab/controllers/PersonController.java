package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.daos.PersonDao;
import pl.coderslab.daos.PersonDetailsDao;
import pl.coderslab.entities.Person;
import pl.coderslab.entities.PersonDetails;
import pl.coderslab.utils.RandomString;

@Controller
public class PersonController {

    private PersonDao personDao;
    private PersonDetailsDao personDetailsDao;

    @Autowired
    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/create-person")
    @ResponseBody
    public String createPerson(){
        RandomString randomString = new RandomString(10);

        PersonDetails personDetails = new PersonDetails(randomString.nextString(),
                randomString.nextString(),
                randomString.nextString(),
                randomString.nextString(),
                randomString.nextString()
        );

        personDetailsDao.saveDetailsPerson(personDetails);

        Person person = new Person(randomString.nextString(),
                randomString.nextString(),
                randomString.nextString(),
                personDetails);

        personDao.savePerson(person);

        return person.toString();
    }
}
