package com.example.MailDemo.Filter;

public class FilterCriteriaFactory {

    public Criteria getCriteria(String criteriaName, Object criteriaValue){
        if(criteriaName == null) {
            return null;
        }

        return switch (criteriaName) {
            case "body" -> new BodyCriteria((String) criteriaValue);
            case "subject" -> new SubjectCriteria((String) criteriaValue);
            case "sender" -> new SenderCriteria((String) criteriaValue);
            case "recipient" -> new RecipientCriteria((String) criteriaValue);
            case "priority" -> new PriorityCriteria((Integer) criteriaValue);
            case "timestamp" -> new TimestampCriteria((Long) criteriaValue);
            default -> throw new IllegalArgumentException("There is no criteria with name " + criteriaName);
        };
    }
}
