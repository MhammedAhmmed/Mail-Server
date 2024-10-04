package com.example.MailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trash")
public class TrashFolderController {
    @Autowired
    private TrashFolderService trashFolderService;

    @GetMapping
    public ResponseEntity<List<Email>> getTrashedEmails(@PathVariable String emailAddress){
        return new ResponseEntity<>(trashFolderService.getTrashedEmails(emailAddress), HttpStatus.OK);
    }
    @PostMapping("/removeFromFolderName")
    public void addEmailsToTrash(@PathVariable String removeFromFolderName, @RequestBody daoEmailsId request){
        trashFolderService.moveEmailsToTrash(removeFromFolderName, request.getEmailsId(), request.getEmailAddress());
    }
    @DeleteMapping
    public List<Email> removeEmailsFromTrash(@RequestBody daoEmailsId request){
        return trashFolderService.removeEmailsFromTrash(request.getEmailsId(), request.getEmailAddress());
    }
}
