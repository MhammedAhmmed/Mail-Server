package com.example.MailDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmailAddress(String emailAddress);
}
