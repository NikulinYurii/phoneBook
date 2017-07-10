package app.service;

import app.model.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yurii on 09.07.17.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserExist(User user) {
        boolean isExist = userRepository.findOne(user.getLogin()) != null ? true : false;
        return isExist;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

}
