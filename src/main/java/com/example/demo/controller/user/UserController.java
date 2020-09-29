package com.example.demo.controller.user;

import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("masterchef/user")
    public void createUser(@RequestBody UserRequest users) {
        userService.createNewUser(users.getFirstName(), users.getLastName(), users.getUsername(), users.getPassword());
    }   // web:   http://localhost:8080/masterchef/user     login.html

}
