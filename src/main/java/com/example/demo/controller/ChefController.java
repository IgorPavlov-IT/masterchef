package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChefController {


    @Autowired
    private ChefService chefService;


    // tehtud Kildu
//    @PostMapping ("masterchef/user")
//    public String createUser
//    return = "OK";


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

//


}





