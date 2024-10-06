package com.example.MailDemo.Contact;

import lombok.Data;

import java.util.List;

@Data
// Data access object for receive list of contacts name
public class daoContacts {
    private String emailAddress;
    private List<String>contactNames;
}
