package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entities.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/create")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "studentForm";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createStudent(@ModelAttribute Student student){
        return student.toString();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public Collection<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Php");
        skills.add("python");
        skills.add("ruby");
        return skills;
    }

    @ModelAttribute("hobbiesList")
    public Collection<String> hobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Biking");
        hobbies.add("Swiming");
        hobbies.add("Reading");
        hobbies.add("Sining");
        return hobbies;
    }

}
