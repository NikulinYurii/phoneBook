package app.repository;

import app.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yurii on 09.07.17.
 */
public interface UserRepository extends CrudRepository<User, String>  {
}
