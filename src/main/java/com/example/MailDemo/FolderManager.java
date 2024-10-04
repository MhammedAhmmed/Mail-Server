//package com.example.MailDemo;
//
//import java.util.*;
//
//public class FolderManager {
//    private Map<String, Folder> folders;
//
//    public Map<String, Folder> getFolders() {
//        return folders;
//    }
//    public void setFolders(Map<String, Folder> folders){
//        this.folders = folders;
//    }
//    public FolderManager() {
//        folders = new HashMap<>();
//        createDefaultFolders();
//    }
//    private void createDefaultFolders() {
//        folders.put(FolderType.INBOX, new Folder(FolderType.INBOX));
//        folders.put(FolderType.SENT, new Folder(FolderType.SENT));
//        folders.put(FolderType.DRAFTS, new Folder(FolderType.DRAFTS));
//    }
//
//    // Create folder
//    public void createFolder(String folderName) {
//        if (!folders.containsKey(folderName)) {
//            folders.put(folderName, new Folder(folderName));
//        }
//    }
//    // Get All email from folder (Read)
//    public Set<Email> getFolder(String folderName) {
//        if (!folders.containsKey(folderName)) {
//            throw new NoSuchElementException("Folder with name " + folderName + " not existence");
//        }
//        return folders.get(folderName).getEmailSet();
//    }
//
//    // Delete folder
//    public void deleteFolder(String folderName) { // folderName must not be from default folders
//        if (!folders.containsKey(folderName)) {
//            throw new NoSuchElementException("Folder with name " + folderName + " not existence");
//        }
//        folders.remove(folderName);
//    }
//
//    // Rename Folder
//    public void renameFolder(String originalName, String newName) {
//        if (!folders.containsKey(originalName)) {
//            throw new NoSuchElementException("Folder with name " + originalName + " not existence");
//        }
//        if (folders.containsKey(newName)) {
//            throw new IllegalArgumentException("Folder with name " + newName + " already exist");
//        }
//        if(isDefaultFolder(originalName)){
//            throw new IllegalArgumentException("Can not rename the default folders");
//        }
//
//        Folder tempFolder = folders.remove(originalName);
//        folders.put(newName, tempFolder);
//    }
//
//    private boolean isDefaultFolder(String folderName){
//        return folderName.equals(FolderType.INBOX) || folderName.equals(FolderType.SENT) || folderName.equals(FolderType.DRAFTS);
//    }
//    public void addEmailsToFolder(String folderName, List<Email> emails){
//        if (!folders.containsKey(folderName)) {
//            this.createFolder(folderName);
//        }
//
//        Folder folder = folders.get(folderName);
//        for(Email email : emails){
//            if(email.getTimestamp() == 0){
//                email.setTimestamp();
//            }
//            folder.getEmailSet().add(email);
//            folder.getEmailsMap().put(email.getId(), email);
//        }
//    }
//
//    // Get a single email
//    public Email getSingleEmail(String folderName, String emailId) {
//        if (!folders.containsKey(folderName)) {
//            throw new NoSuchElementException("Folder with name " + folderName + " not existence");
//        }
//        if (folders.get(folderName).getEmailsMap().containsKey(emailId)) {
//            return folders.get(folderName).getEmailsMap().get(emailId);
//        }
//        throw new NoSuchElementException("Email with id " + emailId + "not existence in folder " + folderName);
//    }
//
//    // Delete bulk of emails
//    public void deleteEmails(String folderName, List<String> emailsId) {
//        if (!folders.containsKey(folderName)) {
//            throw new NoSuchElementException("Folder with name " + folderName + " not existence");
//        }
//
//        Folder tempFolder = folders.get(folderName);
//
//        for (String emailId : emailsId) {
//            if (tempFolder.getEmailsMap().containsKey(emailId)) {
//                Email removedEmail = tempFolder.getEmailsMap().remove(emailId);
//                tempFolder.getEmailSet().remove(removedEmail);
//            }
//            tempFolder.getEmailsMap().remove(emailId);
//        }
//        folders.put(folderName, tempFolder);
//    }
//}
