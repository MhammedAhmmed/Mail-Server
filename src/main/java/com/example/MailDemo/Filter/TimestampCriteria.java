package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class TimestampCriteria implements Criteria {
    private final long timestamp;

    public TimestampCriteria(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public List<Email> meetCriteria(List<Email> emails) {
        List<Email> criteriaResult = new ArrayList<>();
        for (Email email : emails) {
            if (email.getTimestamp() == timestamp) {
                criteriaResult.add(email);
            }
        }
        return criteriaResult;
    }
}
