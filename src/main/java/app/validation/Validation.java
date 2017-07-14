package app.validation;

/**
 * Created by yurii on 12.07.17.
 */
public interface Validation {

    boolean validLogin(String login);

    boolean validPass(String pass);

    boolean validPhone(String phone);

    boolean validFIO(String text, int size);
}
