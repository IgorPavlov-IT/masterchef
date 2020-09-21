package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChefController {


    @Autowired
    private ChefService chefService;

        @PostMapping("masterchef/user")
        public void createUser(@RequestBody UserDTO users) {
            chefService.createNewUser(users.getFirstName(), users.getLastName(), users.getUsername(), users.getPassword());
        } // web:   http://localhost:8080/masterchef/user

//    @PostMapping ("client/new")
//    public Strin createUser
//    return = "OK";

//    @PostMapping ("recipe/new")
//    public String createReceipe
//    return = "OK";

//    @GetMapping ("recipe")
//    public String showRecipe
//    return = "OK";

//    @GetMapping ("recipe/full")
//    public String showFullRecipe
//    return = "OK";

//    @GetMapping ("recipe/list")
//    public String searchRecipeList
//    return = "OK";

//    @GetMapping ("recipe/list")
//    public String searchByIngredientRecipeList
//    return = "OK";

    }






