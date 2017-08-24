package app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yurii on 18.07.17.
 */
public class NameValidator implements ConstraintValidator<ValidName, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String NAME_PATTERN_EN = "([A-Z])[a-z]{4,}";

    @Override
    public void initialize(ValidName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validName(value);
    }

    private boolean validName(String value) {
        pattern = Pattern.compile(NAME_PATTERN_EN);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
