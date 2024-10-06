package com.example.MailDemo.Folder;

import com.example.MailDemo.Email.Email;
import com.example.MailDemo.FolderType;
import com.example.MailDemo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FolderManagerService {
    @Autowired
    private UserService userService;
    @Autowired
    private FolderRepository folderRepository;

    // Read Folder
    public List<Email> getFolderEmails(String folderName, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        Optional<Folder> folder = this.getFolder(folderName, emailAddress);
        if(folder.isPresent()){
            return folder.get().getEmails();
        }

        throw new NoSuchElementException("There is no folder with name " + folderName);
    }
    // Create Folder
    public void createFolder(String folderName, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        Optional<Folder> folder = this.getFolder(folderName, emailAddress);
        if(folder.isPresent()){ // this mean that there is folder with the new name
            throw new IllegalArgumentException("You have already folder with name " + folderName);
        }

        Folder newFolder = new Folder(folderName);
        newFolder.setUser(userService.getUserDB().get(emailAddress));
        newFolder = folderRepository.save(newFolder);

        userService.getUserDB().get(emailAddress).getFolders().add(newFolder);
    }


    // Update Folder
    public void renameFolder(String originalName, String newName, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        if(isDefaultFolder(originalName)){
            throw new IllegalArgumentException("Can not change the name of default folder");
        }
        if(isDefaultFolder(newName)){
            throw new IllegalArgumentException("Can not set folder name to the default folder names");
        }

        // Check if there is folder with the new name folder
        Optional<Folder> folderWithNewName = this.getFolder(newName, emailAddress);
        if(folderWithNewName.isPresent()){
            throw new IllegalArgumentException("You have already folder with name " + originalName);
        }

        // Check that there is folder with the original name
        Optional<Folder> folderWithTheOriginalName = this.getFolder(originalName, emailAddress);
        if(folderWithTheOriginalName.isPresent()){
            folderWithTheOriginalName.get().setName(newName);
        }else {
            throw new NoSuchElementException("There is no folder with name " + originalName);
        }
    }

    // Delete Folder
    public void deleteFolder(String folderName, String emailAddress){
        userService.checkThatUserIsLogged(emailAddress);

        if(isDefaultFolder(folderName)){
            throw new IllegalArgumentException("Can not delete the default folders (Inbox, Sent, Drafts, Trash)");
        }

        List<Folder> folders = userService.getUserDB().get(emailAddress).getFolders();
        folders.removeIf(folder -> folder.getName().equals(folderName));
    }
    private boolean isDefaultFolder(String folderName){
        return folderName.equals(FolderType.INBOX) || folderName.equals(FolderType.SENT) ||
               folderName.equals(FolderType.DRAFTS) || folderName.equals(FolderType.TRASH);
    }

    // Check if the folder exist and return it if exist
    private Optional<Folder> getFolder(String folderName, String emailAddress){
        return userService.getUserDB().get(emailAddress).getFolders().stream()
                .filter(folder -> folder.getName().equals(folderName))
                .findFirst();
    }
}
