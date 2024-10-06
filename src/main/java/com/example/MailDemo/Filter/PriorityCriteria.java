package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class PriorityCriteria implements Criteria {
    private final int priority;

    PriorityCriteria(int priority) {
        this.priority = priority;
    }

    @Override
    public List<Email> meetCriteria(List<Email> emails) {
        List<Email> criteriaResult = new ArrayList<>();
        for (Email email : emails) {
            if (email.getPriority() == priority) {
                criteriaResult.add(email);
            }
        }
        return criteriaResult;
    }
}
