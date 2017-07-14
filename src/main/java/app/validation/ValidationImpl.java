package app.validation;

import java.util.regex.Pattern;

/**
 * Created by yurii on 12.07.17.
 */
public class ValidationImpl implements Validation {

    Pattern patternForText = Pattern.compile(
            "[" +
                    "a-zA-Z" +
                    "а-яА-Я" +
                    "]");

    Pattern patternForPhone = Pattern.compile(
            "[" +
                    "+380" +
                    "]"
    );

    Pattern patternForLogin = Pattern.compile(
            "[" +
                    "a-zA-Z" +
                    "]");


    @Override
    public boolean validLogin(String login) {

        if (login.length() >= 3 && patternForLogin.matcher(login).matches()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validPass(String pass) {

        if (pass.length() >= 5) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validPhone(String phone) {

        String p = phone.substring(3);

        if (phone.length() == 13 && patternForPhone.matcher(p).matches()) {
            return true;
        }

        return false;
    }

    @Override
    public boolean validFIO(String text, int size) {

        if (text.length() >= size && patternForText.matcher(text).matches()) {
            return true;
        }

        return false;
    }


}
