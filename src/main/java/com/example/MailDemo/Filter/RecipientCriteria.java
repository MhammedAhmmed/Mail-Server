package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class RecipientCriteria implements Criteria {
    private final String recipient;

    public RecipientCriteria(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public List<Email> meetCriteria(List<Email> emails) {
        List<Email> criteriaResult = new ArrayList<>();
        for (Email email : emails) {
            if (email.getRecipient().equals(recipient)) {
                criteriaResult.add(email);
            }
        }
        return criteriaResult;
    }
}
