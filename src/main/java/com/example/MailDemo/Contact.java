package com.example.MailDemo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "user")
public class Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contactName;

    private String emailAddresses = "";

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Contact(String contactName){
        this.contactName = contactName;
    }
    // Add emails as comma(, ) separated
    public void addEmailAddress(String emailAddress){
        if(emailAddresses.isEmpty()){
            emailAddresses = emailAddress;
        }else{
            if(!emailAddresses.contains(emailAddress)){
                emailAddresses += ", " + emailAddress;
            }
        }
    }
}
