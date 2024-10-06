package com.example.MailDemo.Sorting;

import com.example.MailDemo.Email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sort")
public class SortingController {
    @Autowired
    private SortingService sortingService;
    @GetMapping
    public ResponseEntity<List<Email>> sortEmails(@RequestBody Map<String, String> request){
        return new ResponseEntity<>(sortingService.sortEmails(
                request.get("folderName"),
                request.get("strategyName"),
                request.get("emailAddress")), HttpStatus.OK);
    }
}
