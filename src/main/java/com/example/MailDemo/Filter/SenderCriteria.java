package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class SenderCriteria implements Criteria {

    private final String sender;

    public SenderCriteria(String sender) {
        this.sender = sender;
    }

    @Override
    public List<Email> meetCriteria(List<Email> emails) {
        List<Email> criteriaResult = new ArrayList<>();
        for (Email email : emails) {
            if (email.getSender().equals(sender)) {
                criteriaResult.add(email);
            }
        }
        return criteriaResult;
    }
}
