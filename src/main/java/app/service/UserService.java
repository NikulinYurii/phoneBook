package app.service;

import app.dto.UserDTO;
import app.exceptions.EmailExistsException;
import app.model.Contact;
import app.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yurii on 14.07.17.
 */
public interface UserService {
    User registerNewUserAccount(UserDTO accountDto)
            throws EmailExistsException;

    boolean loginExist(String login);

    boolean chek(String login, String pass);

    void addContact(String login, Contact contact);

    Contact delContact(String login, Contact contact);

    void setContact(String login, Contact contact);

    List<Contact> getContacts(String login);

    List<Contact> getContactsByName(String login);

    List<Contact> getContactsBySurname(String login);

    List<Contact> getContactsByMobile(String login);
}
