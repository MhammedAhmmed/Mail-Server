package com.example.MailDemo.Sorting;

import com.example.MailDemo.Email.Email;

import java.util.List;

public interface SortingStrategy {
    void sort(List<Email> emails);
}
