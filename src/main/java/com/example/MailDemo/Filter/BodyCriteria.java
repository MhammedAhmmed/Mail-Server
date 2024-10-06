package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class BodyCriteria implements Criteria{
    private final String keyWord;
    public BodyCriteria(String keyWord){
        this.keyWord = keyWord;
    }

    @Override
    public List<Email> meetCriteria(List<Email> emails) {
        List<Email>criteriaResult = new ArrayList<>();
        for(Email email: emails){
            if(email.getBody().contains(keyWord)){
                criteriaResult.add(email);
            }
        }
        return criteriaResult;
    }
}
