package app.repository;

import app.model.Contact;
import app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by yurii on 09.07.17.
 */
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> getAllByUserOrderByName(User user);

    List<Contact> getAllByUserOrderBySurname(User user);

    List<Contact> getAllByUserOrderByMobile(User user);
}