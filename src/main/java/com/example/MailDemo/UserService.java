package com.example.MailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final Map<String, User> userDB = new HashMap<>();

    public void loadUser(User user){
        if(!userDB.containsKey(user.getEmailAddress())) {
            userDB.put(user.getEmailAddress(), user);
        }
    }
    public void saveUser(User user){
        userRepository.save(user);
    }

    public void saveUser(String emailAddress){
        userRepository.save(userDB.get(emailAddress));
    }
    public void createUser(String name, String emailAddress, String password){
        User newUser = new User.Builder()
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .setName(name)
                .setFolders(new ArrayList<>())
                .setContacts(new ArrayList<>())
                .build();

        this.addDefaultFolders(newUser);

        saveUser(newUser);
        userDB.put(newUser.getEmailAddress(), newUser);
    }
    public void checkThatUserIsLogged(String emailAddress){
        if(!this.userDB.containsKey(emailAddress)) {
            throw new NoSuchElementException("There is no user with email address " + emailAddress);
        }
    }
    public Map<String, User> getUserDB(){
        return this.userDB;
    }
    private void addDefaultFolders(User user){
        Folder inboxFolder = new Folder(FolderType.INBOX);
        Folder sentFolder = new Folder(FolderType.SENT);
        Folder draftsFolder = new Folder(FolderType.DRAFTS);
        Folder trashFolder = new Folder(FolderType.TRASH);

        inboxFolder.setUser(user);
        sentFolder.setUser(user);
        draftsFolder.setUser(user);
        trashFolder.setUser(user);

        user.getFolders().add(inboxFolder);
        user.getFolders().add(sentFolder);
        user.getFolders().add(draftsFolder);
        user.getFolders().add(trashFolder);
    }
}
