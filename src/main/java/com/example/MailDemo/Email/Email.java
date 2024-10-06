package com.example.MailDemo.Email;

import com.example.MailDemo.Folder.Folder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "folder")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String sender;
    private String recipient;
    private int priority;
    private long timestamp;
    private long sincePutInTrash; // initially 0, and this mean that this email not in the trash

    @ManyToOne
    @JoinColumn(name = "folder_id")
    @JsonBackReference
    private Folder folder;
//
//    public Email(){}
//    private Email(Builder builder) {
//        this.Id = builder.Id;
//        this.subject = builder.subject;
//        this.body = builder.body;
//        this.sender = builder.sender;
//        this.recipient = builder.recipient;
//        this.timestamp = System.currentTimeMillis();
//        this.priority = builder.priority;
//    }
//
//    public String getId() {
//        return Id;
//    }
//
//    public void setId(String id) {
//        Id = id;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getSender() {
//        return sender;
//    }
//
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
//
//    public String getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(String recipient) {
//        this.recipient = recipient;
//    }
//
//    public long getTimestamp() {
//        return timestamp;
//    }
//    public void setTimestamp(){
//        this.timestamp = System.currentTimeMillis();
//    }
//
//    public int getPriority() {
//        return priority;
//    }
//
//    public void setPriority(int priority) {
//        this.priority = priority;
//    }
//
//    public Long getSincePutInTrash() {
//        return sincePutInTrash;
//    }
//
//    public void setSincePutInTrash(Long sincePutInTrash) {
//        this.sincePutInTrash = sincePutInTrash;
//    }
//
//    public static class Builder {
//        private String Id;
//        private String subject;
//        private String body;
//        private String sender;
//        private String recipient;
//        private int priority;
//
//        public Builder setId(String id) {
//            this.Id = id;
//            return this;
//        }
//
//        public Builder setSubject(String subject) {
//            this.subject = subject;
//            return this;
//        }
//
//        public Builder setBody(String body) {
//            this.body = body;
//            return this;
//        }
//
//        public Builder setSender(String sender) {
//            this.sender = sender;
//            return this;
//        }
//
//        public Builder setRecipient(String recipient) {
//            this.recipient = recipient;
//            return this;
//        }
//
//        public Builder setPriority(int priority) {
//            this.priority = priority;
//            return this;
//        }
//
//        public Email build() {
//            return new Email(this);
//        }
//    }
}
