package com.example.MailDemo.SingIn;

import com.example.MailDemo.User.User;
import com.example.MailDemo.User.UserRepository;
import com.example.MailDemo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingInService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserService userService;
    public boolean validSignIn(String emailAddress, String password){
        User user = userRepository.findUserByEmailAddress(emailAddress);
        if(user != null && user.getPassword().equals(password)){
            userService.loadUser(user);
            return true;
        }
        return false;
    }
}
