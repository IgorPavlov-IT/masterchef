package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ChefController {


    @Autowired
    private ChefService chefService;

    @PostMapping("masterchef/user")
    public void createUser(@RequestBody UserDTO users) {
        chefService.createNewUser(users.getFirstName(), users.getLastName(), users.getUsername(), users.getPassword());
    }   // web:   http://localhost:8080/masterchef/user

    @PostMapping("masterchef/recipe/add")
    public void createRecipe(@RequestBody RecipeDTO newRecipeData) {
        chefService.createRecipe(newRecipeData);

    }   // web:   http://localhost:8080/masterchef/recipe/add

    @GetMapping("masterchef/user")
    public UserDTO getUser() {
        return new UserDTO(chefService.getSignUp());
    }   // web: http://localhost:8080/masterchef/user


    @GetMapping("masterchef/recipe/display")
    public String showRecipe(@RequestBody int recipeID) {
        chefService.showRecipe(recipeID);
        return "OK";
    }   // web: http://localhost:8080/masterchef/recipe/display



    @GetMapping("masterchef/recipe/all")
    public List<RecipeDTO> showFullRecipeList() {
        return chefService.showFullRecipeList();
    }   // web: http://localhost:8080/masterchef/recipe/all


    @GetMapping ("masterchef/recipe/searchresult")
    public List<RecipeDTO> searchRecipeList(@RequestBody String searchWord) {
        return chefService.showSearchResultList(searchWord);
    }

//    @GetMapping ("masterchef/recipe/ingredientresult")
//    public String searchByIngredientRecipeList
//    return = "OK";

//    @GetMapping ("masterchef")



}






