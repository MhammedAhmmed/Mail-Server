package com.example.MailDemo.Filter;

import com.example.MailDemo.Email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filter")
public class FilterController {
    @Autowired
    FilterService filterService;
    @GetMapping("/{folderName}")
    public ResponseEntity<List<Email>>filterEmails(@PathVariable String folderName, @RequestBody daoFilterCriterias request){
        return new ResponseEntity<>(filterService.filterEmails(
                folderName,
                request.getCriteria(),
                request.getEmailAddress()), HttpStatus.OK);
    }
}
