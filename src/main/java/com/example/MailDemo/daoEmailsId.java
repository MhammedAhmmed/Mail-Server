package com.example.MailDemo;

import lombok.Data;

import java.util.List;

// Data access object to receive list of emails ids
@Data
public class daoEmailsId {
    private String emailAddress;
    private List<Integer>emailsId;
}
