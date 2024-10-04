package com.example.MailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingUpService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public Boolean validSignUp(String name, String emailAddress, String password){
        User user = userRepository.findUserByEmailAddress(emailAddress);
        if(user != null) { // this mean that there is a user with the same email address
            return false;
        }

        userService.createUser(name, emailAddress, password);
        return true;
    }
}
