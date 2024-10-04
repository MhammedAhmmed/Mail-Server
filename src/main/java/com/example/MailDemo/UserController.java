//package com.example.MailDemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
////    @GetMapping("/save")
////    public void saveUser(){
////        FolderManager folderManager = new FolderManager();
////        TrashFolder trashFolder = new TrashFolder();
////        List<Contact> contacts = new ArrayList<>();
////
////        User user = new User.Builder()
////                .setEmailAddress("mohamed@gmail.com")
////                .setName("Ahmed")
////                .setPassword("1234567")
////                .setFolderManager(folderManager)
////                .setTrashFolder(trashFolder)
////                .setContactList(contacts)
////                .build();
////        userService.saveUser(user);
////    }
////    @GetMapping("/load/{emailAddress}")
////    public boolean loadUser(@PathVariable String emailAddress){
////        return userService.loadUser(emailAddress);
////    }
////    @GetMapping("/allUsers")
////    public List<User> getAllUser(){
////        return userService.getAllUser();
////    }
//}
