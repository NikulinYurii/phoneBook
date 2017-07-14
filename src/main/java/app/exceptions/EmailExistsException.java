package app.exceptions;

/**
 * Created by yurii on 14.07.17.
 */
public class EmailExistsException extends Exception{

    public EmailExistsException(String s) {
        super(s);
    }
}
