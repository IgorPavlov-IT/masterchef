package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChefController {


    @Autowired
        private ChefService chefService;


    // tehtud Kildu
//    @PostMapping ("masterchef/user")
//    public String createUser
//    return = "OK";


    @PostMapping("masterchef/recipe/add")
    public String createRecipe (RecipeDTO newRecipeData) {
        chefService.createRecipe(newRecipeData);

    return "OK";
    }

    // teeb Kildu
//    @GetMapping ("masterchef/recipe/display")
//    public String showRecipe;
//    return = "OK";

//    @GetMapping ("masterchef/recipe/all")
//    public String showFullRecipe
//    return = "OK";

//    @GetMapping ("masterchef/recipe/searchresult")
//    public String searchRecipeList
//    return = "OK";

//    @GetMapping ("masterchef/recipe/ingredientresult")
//    public String searchByIngredientRecipeList
//    return = "OK";

//    @GetMapping ("masterchef")

//







}





