package com.example.MailDemo.Filter;

import lombok.Data;

import java.util.Map;

@Data
public class daoFilterCriterias {
    private String emailAddress;
    private Map<String, Object> criteria;
}
