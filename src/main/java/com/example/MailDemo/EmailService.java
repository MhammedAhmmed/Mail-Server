package com.example.MailDemo;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailRepository emailRepository;

    public void addEmails(String folderName, List<Email> emails, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        Folder folder = this.getFolder(folderName, emailAddress)
                .orElseThrow(() -> new IllegalArgumentException("There is no folder with name " + folderName));

        for(Email email : emails){
            email.setFolder(folder);
            if(email.getTimestamp() == 0){
                email.setTimestamp(System.currentTimeMillis());
            }
            Email savedEmail = emailRepository.save(email);
            folder.getEmails().add(savedEmail);
        }

        userService.saveUser(emailAddress);
    }
    public void deleteEmails(String folderName, List<Integer> emailsId, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        Folder folder = this.getFolder(folderName, emailAddress)
                .orElseThrow(() -> new IllegalArgumentException("There is no folder with name " + folderName));

        folder.getEmails().removeIf(email -> emailsId.contains(email.getId()));

        userService.saveUser(emailAddress);
    }
    // Move bulk of emails form folder to other folder for the same user
    public void moveEmails(String folderNameFrom, String folderNameTo, List<Integer> emailsId, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        Folder fromFolder = this.getFolder(folderNameFrom, emailAddress)
                .orElseThrow(() -> new IllegalArgumentException("There is no folder with name " + folderNameFrom));

        Folder toFolder = this.getFolder(folderNameTo, emailAddress)
                .orElseThrow(() -> new IllegalArgumentException("There is no folder with name " + folderNameTo));


        for(Email email : fromFolder.getEmails()){
            if(emailsId.contains(email.getId())){
                email.setFolder(toFolder);
                toFolder.getEmails().add(email);
            }
        }

        fromFolder.getEmails().removeIf(email -> emailsId.contains(email.getId()));

        userService.saveUser(emailAddress);
    }
    // Check if the folder exist and return it if exist
    private Optional<Folder> getFolder(String folderName, String emailAddress){
        return userService.getUserDB().get(emailAddress).getFolders().stream()
                .filter(folder -> folder.getName().equals(folderName))
                .findFirst();
    }
}
