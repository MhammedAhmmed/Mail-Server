package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;

import java.util.List;

public interface Criteria {
    List<Email> meetCriteria(List<Email>emails);
}
