package com.example.MailDemo.Sorting;

import com.example.MailDemo.Email.Email;
import com.example.MailDemo.Folder.Folder;
import com.example.MailDemo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SortingService {
    @Autowired
    private UserService userService;
    private final SortingStrategyFactory sortingStrategyFactory = new SortingStrategyFactory();

    public List<Email> sortEmails(String folderName, String strategyName, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        Folder folder = this.getFolder(folderName, emailAddress)
                .orElseThrow(() -> new IllegalArgumentException("There is no folder with name " + folderName));

        SortingStrategy sortingStrategy = sortingStrategyFactory.getStrategy(strategyName);
        sortingStrategy.sort(folder.getEmails());

        return folder.getEmails();
    }

    // Check if the folder exist and return it if exist
    private Optional<Folder> getFolder(String folderName, String emailAddress){
        return userService.getUserDB().get(emailAddress).getFolders().stream()
                .filter(folder -> folder.getName().equals(folderName))
                .findFirst();
    }
}
