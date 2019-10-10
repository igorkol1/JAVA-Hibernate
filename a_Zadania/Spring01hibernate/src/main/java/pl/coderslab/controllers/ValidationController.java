package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dtos.ValidationResponse;
import pl.coderslab.entities.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ValidationController {

    private Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public String validationTest(Model model){
        Book book = new Book();
        Set<ConstraintViolation<Book>> validations = validator.validate(book);
        List<ValidationResponse> bookValidationResponses;
        bookValidationResponses = validations.stream()
                .map(validation -> new ValidationResponse(validation.getPropertyPath().toString(),validation.getMessage()))
                .collect(Collectors.toList());
        model.addAttribute("bookValidationResponses",bookValidationResponses);

//        if(!validations.isEmpty()){
//            return validations.toString();
//        }
        return "validationTest";
    }
}
