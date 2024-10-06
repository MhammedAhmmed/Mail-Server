package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class SubjectCriteria implements Criteria {
    private final String subject;

    public SubjectCriteria(String subject) {
        this.subject = subject;
    }

    @Override
    public List<Email> meetCriteria(List<Email> emails) {
        List<Email> criteriaResult = new ArrayList<>();
        for (Email email : emails) {
            if (email.getSubject().equals(subject)) {
                criteriaResult.add(email);
            }
        }
        return criteriaResult;
    }
}
