package com.example.MailDemo.SignUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/signUp")
public class SignUpController {
    @Autowired
    private SingUpService singUpService;

    @PostMapping
    public ResponseEntity<Boolean> validSignUp(@RequestBody Map<String, String> requestBody){
        String name = requestBody.get("name");
        String emailAddress = requestBody.get("emailAddress");
        String password = requestBody.get("password");

        return new ResponseEntity<>(singUpService.validSignUp(name, emailAddress, password), HttpStatus.OK);
    }
}
