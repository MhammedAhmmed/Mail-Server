package com.example.MailDemo.Sorting;

import com.example.MailDemo.Email.Email;

import java.util.Comparator;
import java.util.List;

public class PrioritySorting implements SortingStrategy{
    public void sort(List<Email>emails){
        emails.sort(Comparator.comparing(Email::getPriority));
    }
}
