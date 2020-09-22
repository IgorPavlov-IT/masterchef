package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ChefService {

    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private SignUpRepository signUpRepository;


    /*    public addRecipeToDB ();*/

    public void createNewUser(String firstName, String lastName, String username, String password) {
        chefRepository.createSqlUser(firstName, lastName, username, password);
    }

    public void createRecipe(RecipeDTO newRecipeData) {
        chefRepository.createRecipe(newRecipeData);
    }

    public String retrieveCookingTime(int tempInput) {
        chefRepository.retrieveCookingTime(tempInput);
        return "ok";
    }

    public String retrieveMealType(int tempInput) {
        chefRepository.retrieveType(tempInput);
        return "ok";
    }

    public SignUp getSignUp() {
        System.out.println(signUpRepository.getOne(1));
        return signUpRepository.getOne(1);
    }

}
