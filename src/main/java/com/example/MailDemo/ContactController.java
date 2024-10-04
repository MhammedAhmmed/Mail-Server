package com.example.MailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/{emailAddress}")
    public ResponseEntity<List<Contact>> getContacts(@PathVariable String emailAddress){
        List<Contact>contacts = contactService.getContacts(emailAddress);
        return ResponseEntity.ok(contacts);
    }
    @PostMapping("/addContact")
    public ResponseEntity<Void> addContact(@RequestBody Map<String,String> contactRequest){
        contactService.addContact(contactRequest.get("contactName"), contactRequest.get("emailAddress"));
        return ResponseEntity.status(201).build(); // 201 is created status
    }
    @PostMapping("/addEmailAddress")
    public ResponseEntity<Void> addEmailAddressToContact(@RequestBody Map<String, String> contactRequest) {
        contactService.addEmailAddressToContact(contactRequest.get("contactName"),
                contactRequest.get("contactEmailAddress"),
                contactRequest.get("emailAddress"));
        return ResponseEntity.ok().build(); // indicates that the request has succeeded
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteContacts(@RequestBody daoContacts request){
        contactService.deleteContacts(request.getContactNames(), request.getEmailAddress());

        return ResponseEntity.ok().build(); // indicates that the request has succeeded
    }

}
