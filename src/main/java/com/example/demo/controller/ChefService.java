package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void createRecipe(RecipeWithIngredientsDTO newRecipeData) {
        Integer recipeId = chefRepository.createRecipe(newRecipeData.getName(), newRecipeData.getCookingTime(), newRecipeData.getType(), newRecipeData.getNotes(), newRecipeData.getInstruction());
        for (IngredientsDTO ingredient : newRecipeData.getIngredients()) {
            chefRepository.createRecipeIngredient(recipeId, ingredient);
        }
    }

    public RecipeDTO showRecipe(int recipeID) {
        return chefRepository.showRecipe(recipeID);
    }

    public List<RecipeWithClassificatorsDTO> showFullRecipeList() {
        return chefRepository.showFullRecipeTable();
    }

    public List<RecipeDTO> showSearchResultList(String searchWord) {
        return chefRepository.showRecipeSearchList(searchWord);
    }

    public String retrieveCookingTime(int tempInput) {
        chefRepository.retrieveCookingTime(tempInput);
        return "ok";
    }

    public String retrieveMealType(int tempInput) {
        chefRepository.retrieveType(tempInput);
        return "ok";
    }

    public ClassificatorsResponse getSelectInput() {
        ClassificatorsResponse response = new ClassificatorsResponse();
        response.setIngredients(chefRepository.getIngredientList());
        response.setUnits(chefRepository.getUnitList());
        response.setCookingTime(chefRepository.getCookingTimeList());
        response.setMealType(chefRepository.getMealTypeList());
        return response;
    }

/*    public SignUp getSignUp() {
        System.out.println(signUpRepository.getOne(1));
        return signUpRepository.getOne(1);
    }*/

}
