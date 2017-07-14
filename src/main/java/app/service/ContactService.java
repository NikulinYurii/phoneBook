package app.service;

import app.model.Contact;
import app.model.User;
import app.repository.ContactRepository;
import app.validation.Validation;
import app.validation.ValidationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yurii on 09.07.17.
 */
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private Validation validation = new ValidationImpl();

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean isContactExist(Contact contact) {
        boolean isExist = contactRepository.findOne(contact.getId()) == null ? true : false;
        return isExist;
    }

    public void addContact(Contact contact) {
        if (isContactExist(contact) &&
                validation.validFIO(contact.getName(),4) &&
                validation.validFIO(contact.getSurname(),4) &&
                validation.validFIO(contact.getMiddle_name(),4) &&
                contact.getMobile()!=null)//todo valid email

        contactRepository.save(contact);
    }

    public void updateContact(Contact currentContact) {
        contactRepository.delete(currentContact.getId());
        contactRepository.save(currentContact);
    }

    public void dellContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public List<Contact> getAll() {
        List<Contact> contacts = null;
        for (Contact contact : contactRepository.findAll()) {
            contacts.add(contact);
        }
        return contacts;
    }

    public List<Contact> getAllSortedByName(User user){
        return contactRepository.getAllByUserOrderByName(user);
    }

    public List<Contact> getAllSortedBySername(User user){
        return contactRepository.getAllByUserOrderBySurname(user);
    }

    public List<Contact> getAllSortedByPhone(User user){
        return contactRepository.getAllByUserOrderByMobile(user);
    }
}
