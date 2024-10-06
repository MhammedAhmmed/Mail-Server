package com.example.MailDemo.SingIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/signIn")
public class SignInController {
    @Autowired
    private SingInService singInService;

    @PostMapping
    public ResponseEntity<Boolean> validSignIn(@RequestBody Map<String, String> requestBody){
        String emailAddress = requestBody.get("emailAddress"); // emailAddress : mo@gmail.com
        String password = requestBody.get("password"); // password : 12345

        return new ResponseEntity<>(singInService.validSignIn(emailAddress, password), HttpStatus.OK);
    }
}
