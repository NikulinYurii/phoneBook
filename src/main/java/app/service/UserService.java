package app.service;

import app.dto.UserDTO;
import app.exceptions.EmailExistsException;
import app.model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yurii on 14.07.17.
 */
public interface UserService {
    User registerNewUserAccount(UserDTO accountDto)
            throws EmailExistsException;
}
