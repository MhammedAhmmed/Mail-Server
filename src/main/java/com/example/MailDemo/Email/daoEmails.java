package com.example.MailDemo.Email;

import lombok.Data;

import java.util.List;

// Data access object for receive list of emails
@Data
public class daoEmails {
    private String emailAddress;
    private List<Email> emails;
}
