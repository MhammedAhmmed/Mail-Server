package com.example.MailDemo.Folder;

import com.example.MailDemo.Email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/folder")
public class FolderManagerController {
    @Autowired
    private FolderManagerService folderManagerService;

    @GetMapping("/getFolder/{folderName}")
    public ResponseEntity<List<Email>> getFolderEmails(@PathVariable String folderName, @RequestParam String emailAddress){
        return new ResponseEntity<>(folderManagerService.getFolderEmails(folderName, emailAddress), HttpStatus.OK);
    }
    @GetMapping("/createFolder/{folderName}")
    public void createFolder(@PathVariable String folderName, @RequestParam String emailAddress) {
        folderManagerService.createFolder(folderName, emailAddress);
    }

    @PatchMapping("/renameFolder/{originalName}/{newName}")
    public void renameFolder(@PathVariable String originalName, @PathVariable String newName, @RequestParam String emailAddress) {
        folderManagerService.renameFolder(originalName, newName, emailAddress);
    }


    @DeleteMapping("/deleteFolder/{folderName}")
    public void deleteFolder(String folderName, String emailAddress){
        folderManagerService.deleteFolder(folderName, emailAddress);
    }
}
