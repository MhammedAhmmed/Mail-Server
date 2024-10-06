package com.example.MailDemo.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/addEmails/{folderName}")
    public void addEmails(@PathVariable String folderName, @RequestBody daoEmails request){
        emailService.addEmails(folderName, request.getEmails(), request.getEmailAddress());
    }

    @DeleteMapping("/deleteEmails/{folderName}")
    public void deleteEmailsFromFolder(@PathVariable String folderName, @RequestBody daoEmailsId request){
        emailService.deleteEmails(folderName, request.getEmailsId(), request.getEmailAddress());
    }

    @PostMapping("/moveEmails/{folderNameFrom}/{folderNameTo}")
    public void moveEmails(@PathVariable String folderNameFrom, @PathVariable String folderNameTo, @RequestBody daoEmailsId request) {
        emailService.moveEmails(folderNameFrom, folderNameTo, request.getEmailsId(), request.getEmailAddress());
    }
}
