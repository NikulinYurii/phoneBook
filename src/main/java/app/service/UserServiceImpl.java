package app.service;

import app.dto.UserDTO;
import app.exceptions.EmailExistsException;
import app.model.Contact;
import app.model.User;
import app.repository.ContactRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yurii on 09.07.17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDTO accountDto) throws EmailExistsException {

        if (loginExist(accountDto.getLogin())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + accountDto.getLogin());
        }

        User user = new User();
        user.setName(accountDto.getFirstName());
        user.setSurname(accountDto.getLastName());
        //user.setMiddle_name(accountDto.getMiddleName());
        user.setLogin(accountDto.getLogin());
        user.setPass(accountDto.getPassword());

        return userRepository.save(user);
    }

    @Override
    public boolean loginExist(String login) {
        User user = userRepository.findUserByLogin(login);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean chek(String login, String pass) {

        if (!loginExist(login)) {
            return false;
        } else {
            User user = userRepository.findUserByLogin(login);
            if (user.getPass().equals(pass)) {
                return true;
            } else {
                return false;
            }
        }
    }


    @Override
    public void addContact(String login, Contact contact) {
        User user = userRepository.findUserByLogin(login);
        user.getContactList().add(contact);
    }

    @Override
    public Contact delContact(String login, Contact contact) {
        User user = userRepository.findUserByLogin(login);
        user.getContactList().remove(contact);
        return contact;
    }

    @Override
    public void setContact(String login, Contact contact) {
        User user = userRepository.findUserByLogin(login);
        user.getContactList().remove(contact.getId());
        user.getContactList().add(contact);
    }

    @Override
    public List<Contact> getContacts(String login) {
        User user = userRepository.findUserByLogin(login);
        return user.getContactList();
    }

    @Override
    public List<Contact> getContactsByName(String login) {
        User user = userRepository.findUserByLogin(login);
        return contactRepository.getAllByUserOrderByName(user);
    }

    @Override
    public List<Contact> getContactsBySurname(String login) {
        User user = userRepository.findUserByLogin(login);
        return contactRepository.getAllByUserOrderBySurname(user);
    }

    @Override
    public List<Contact> getContactsByMobile(String login) {
        User user = userRepository.findUserByLogin(login);
        return contactRepository.getAllByUserOrderByMobile(user);
    }
}

