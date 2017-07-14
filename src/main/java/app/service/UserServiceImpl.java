package app.service;

import app.dto.UserDTO;
import app.exceptions.EmailExistsException;
import app.model.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yurii on 09.07.17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDTO accountDto)
            throws EmailExistsException {

        if (loginExist(accountDto.getLogin())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + accountDto.getLogin());
        }

        User user = new User();
        user.setName(accountDto.getFirstName());
        user.setSurname(accountDto.getLasrName());
        user.setMiddle_name(accountDto.getMiddleName());
        user.setLogin(accountDto.getLogin());
        user.setPass(accountDto.getPassword());

        return repository.save(user);
    }

    private boolean loginExist(String login) {
        User user = repository.findUserByLogin(login);
        if (user != null) {
            return true;
        }
        return false;
    }
}

