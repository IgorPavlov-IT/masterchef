package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ChefService {

    @Autowired
    private ChefRepository chefRepository;


    public String createRecipe(RecipeDTO newRecipeData) {
        chefRepository.createRecipe(newRecipeData);
        return "ok";
    }

    public RecipeDTO showRecipe (int recipeID) {

        return chefRepository.showRecipe(recipeID);

    }

    public List<RecipeDTO> showFullRecipeList () {
        return chefRepository.showFullRecipeTable();
    }

    public String retrieveCookingTime (int tempInput) {
        chefRepository.retrieveCookingTime(tempInput);
        return "ok";
    }


    public String retrieveMealType(int tempInput) {
        chefRepository.retrieveType(tempInput);
        return "ok";
    }
}
