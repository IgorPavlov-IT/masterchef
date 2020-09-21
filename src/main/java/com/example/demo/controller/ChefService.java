package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ChefService {

    @Autowired
    private ChefRepository chefRepository;


    /*    public addRecipeToDB ();*/

    public void createNewUser(String firstName, String lastName, String username, String password) {
        chefRepository.createSqlUser(firstName, lastName, username, password);


    public String createRecipe(RecipeDTO newRecipeData) {
        chefRepository.createRecipe(newRecipeData);
        return "ok";
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
