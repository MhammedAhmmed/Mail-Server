package com.example.MailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrashFolderService {
    @Autowired
    private UserService userService;

    // (Read)
    public List<Email> getTrashedEmails(String emailAddress) {
        userService.checkThatUserIsLogged(emailAddress);

        Folder trashFolder = this.getFolder(FolderType.TRASH, emailAddress).
                orElseThrow(() -> new IllegalArgumentException("Trash folder does not exist !!"));

        this.trashFilter(trashFolder.getEmails()); // remove any email that pass 30 day in trash

        return trashFolder.getEmails();
    }

    // Add list of emails to trash folder and remove this emails from the original folder
    // (Add)
    public void moveEmailsToTrash(String removeFromFolderName, List<Integer> emailsId, String emailAddress) {
        userService.checkThatUserIsLogged(emailAddress);

        Folder removeFromFolder = this.getFolder(removeFromFolderName, emailAddress)
                .orElseThrow(() -> new IllegalArgumentException("There is no folder with name " + removeFromFolderName));


        Folder trashFolder = this.getFolder(FolderType.TRASH, emailAddress).
                orElseThrow(() -> new IllegalArgumentException("Trash folder does not exist !!"));

        for(Email email : removeFromFolder.getEmails()){
            if(emailsId.contains(email.getId())){
                email.setSincePutInTrash(System.currentTimeMillis());
                email.setFolder(trashFolder);
                trashFolder.getEmails().add(email);
            }
        }

        removeFromFolder.getEmails().removeIf(email -> emailsId.contains(email.getId()));

        userService.saveUser(emailAddress);
    }

    // Remove emails from trash list and return this emails to be put in another folder or for something else
    //(Delete)
    public List<Email> removeEmailsFromTrash(List<Integer> emailsId, String emailAddress) {
        userService.checkThatUserIsLogged(emailAddress);

        Folder trashFolder = this.getFolder(FolderType.TRASH, emailAddress).
                orElseThrow(() -> new IllegalArgumentException("Trash folder does not exist !!"));


        List<Email> unTrashedEmails = new ArrayList<>();
        for (Email email : trashFolder.getEmails()){
            if(emailsId.contains(email.getId())){
                email.setSincePutInTrash(0);
                email.setFolder(null);

                unTrashedEmails.add(email);
            }
        }

        userService.saveUser(emailAddress);

        return unTrashedEmails;
    }

    // Remove any email which put in the trash from 30 day or longer
    private void trashFilter( List<Email> trashedEmails) {
        for (Email email : trashedEmails) {
            long thirtyDay = System.currentTimeMillis() * 1000 * 60 * 60 * 24 * 30L;

            if (System.currentTimeMillis() > email.getSincePutInTrash() + thirtyDay) {
                trashedEmails.remove(email);
            }
        }
    }

    // Check if the folder exist and return it if exist
    private Optional<Folder> getFolder(String folderName, String emailAddress){
        return userService.getUserDB().get(emailAddress).getFolders().stream()
                .filter(folder -> folder.getName().equals(folderName))
                .findFirst();
    }

}
