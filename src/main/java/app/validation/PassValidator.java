package app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yurii on 18.07.17.
 */
public class PassValidator implements ConstraintValidator<ValidPass, String> {

    private Pattern pattern;
    private Matcher matcher;
    private final int MIN_SIZE = 5;

    @Override
    public void initialize(ValidPass constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.length() < MIN_SIZE) {
            return false;
        } else {
            return true;
        }
    }
}
