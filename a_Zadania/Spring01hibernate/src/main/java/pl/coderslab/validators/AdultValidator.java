package pl.coderslab.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.util.Date;

public class AdultValidator implements ConstraintValidator<Adult,Integer> {

    private static final int ADULT_AGE = 18;

    @Override
    public void initialize(Adult constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().getYear()-year>=ADULT_AGE;
    }
}
