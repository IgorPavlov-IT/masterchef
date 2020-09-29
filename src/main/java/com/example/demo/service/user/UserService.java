package com.example.demo.service.user;

import com.example.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /*    public addRecipeToDB ();*/
    public void createNewUser(String firstName, String lastName, String username, String password) {
        userRepository.createSqlUser(firstName, lastName, username, password);
    }
}
