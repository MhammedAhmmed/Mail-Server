package com.example.MailDemo.User;

import com.example.MailDemo.Contact.Contact;
import com.example.MailDemo.Folder.Folder;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String emailAddress;

    private String password;
    private String name;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Folder>folders;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List <Contact> contacts;

    private User(Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
        this.name = builder.name;
        this.folders = builder.folders;
        this.contacts = builder.contacts;

    }

    public static class Builder {
        private String emailAddress;
        private String password;
        private String name;
        private List<Folder>folders;
        private List<Contact> contacts;



        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setContacts(List<Contact> contacts){
            this.contacts = contacts;
            return this;
        }
        public Builder setFolders(List<Folder> folders){
            this.folders = folders;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
