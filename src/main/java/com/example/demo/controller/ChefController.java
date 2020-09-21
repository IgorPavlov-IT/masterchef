package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChefController {


    @Autowired
    private ChefService chefService;

        @PostMapping("masterchef/user")
        public void createUser(@RequestBody UserDTO users) {
            chefService.createNewUser(users.getFirstName(), users.getLastName(), users.getUsername(), users.getPassword());
        } // web:   http://localhost:8080/masterchef/user



    @PostMapping("masterchef/recipe/add")
    public void createRecipe(@RequestBody RecipeDTO newRecipeData) {
        chefService.createRecipe(newRecipeData);
    }


    @GetMapping("masterchef/recipe/display")
    public String showRecipe(@RequestBody int recipeID) {
        chefService.showRecipe(recipeID);
        return "OK";

    }



    @GetMapping ("masterchef/recipe/{all}")
    public String showFullRecipe() {
        chefService.showFullRecipeList();
        return "OK";

    }


//    @GetMapping ("masterchef/recipe/searchresult")
//    public String searchRecipeList
//    return = "OK";

//    @GetMapping ("masterchef/recipe/ingredientresult")
//    public String searchByIngredientRecipeList
//    return = "OK";

//    @GetMapping ("masterchef")




}






