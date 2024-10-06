package com.example.MailDemo.Contact;

import com.example.MailDemo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private UserService userService;

    // Get all contacts
    public List<Contact> getContacts(String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        return userService.getUserDB().get(emailAddress).getContacts();
    }

    // Create new contacts
    public void addContact(String contactName, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        List<Contact> contacts = userService.getUserDB().get(emailAddress).getContacts();

        for (Contact contact : contacts){
            if(contact.getContactName().equals(contactName)){
                throw new IllegalArgumentException("There is contact with name " + contactName);
            }
        }

        Contact contact = new Contact(contactName);
        contact.setUser(userService.getUserDB().get(emailAddress));
        contacts.add(contact);

        userService.saveUser(emailAddress);
    }

    public void addEmailAddressToContact(String contactName, String contactEmailAddress, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        List<Contact> contacts = userService.getUserDB().get(emailAddress).getContacts();

        boolean findContact = false;
        for(Contact contact : contacts){
            if(contact.getContactName().equals(contactName)){
                contact.addEmailAddress(contactEmailAddress);
                findContact = true;
                break;
            }
        }

        if(!findContact){
            throw new IllegalArgumentException("There is no contact with name " + contactName);
        }

        userService.saveUser(emailAddress);
    }
    // Delete contact
    public void deleteContacts(List<String> contactNames, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        List<Contact> contacts = userService.getUserDB().get(emailAddress).getContacts();

        boolean removed = contacts.removeIf(contact -> contactNames.contains(contact.getContactName()));
        if(!removed){
            throw new IllegalArgumentException("There is no contacts with this names to be deleted");
        }
        userService.saveUser(emailAddress);
    }
}
