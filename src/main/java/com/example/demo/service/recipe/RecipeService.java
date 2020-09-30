package com.example.demo.service.recipe;


import com.example.demo.controller.*;
import com.example.demo.controller.recipe.ClassificatorsResponse;
import com.example.demo.controller.recipe.RecipeWithIngredientsRequest;
import com.example.demo.repository.recipe.IngredientFullEntity;
import com.example.demo.repository.recipe.RecipeFullEntity;
import com.example.demo.repository.recipe.RecipeRepository;
import com.example.demo.repository.recipe.RecipeIngredientEntity;
import com.example.demo.repository.signup.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private SignUpRepository signUpRepository;

    public void createRecipe(RecipeWithIngredientsRequest newRecipeData, String selectedIngredients) {
        Integer recipeId = recipeRepository.createRecipe(newRecipeData.getName(), newRecipeData.getCookingTime(), newRecipeData.getType(), newRecipeData.getNotes(), newRecipeData.getInstruction(), selectedIngredients);
        for (IngredientsDTO ingredient : newRecipeData.getIngredients()) {
            recipeRepository.createRecipeIngredient(recipeId, ingredient);
        }
    }

    public FullRecipeResponse showRecipe(int recipeID) {
        RecipeFullEntity recipeEntity = recipeRepository.getFullRecipe(recipeID);
        List<IngredientFullEntity> ingredientEntityList = recipeRepository.getFullIngredients(recipeID);
        return new FullRecipeResponse(recipeEntity, ingredientEntityList);
    }

    public List<RecipeWithClassificatorsDTO> showFullRecipeList() {
        List<RecipeWithClassificatorsDTO> result = recipeRepository.showFullRecipeTable();
        for (RecipeWithClassificatorsDTO recipe : result) {
            String ingredient = "";
            List<RecipeIngredientEntity> ingredients = recipeRepository.getRecipeIngredients(recipe.getId());
            for (RecipeIngredientEntity ingredientNameDTO : ingredients) {
                if(ingredientNameDTO.isShowInRecipe()){
                    ingredient += ingredientNameDTO.getName() + " ";
                }
            }
            recipe.setIngredients(ingredient);
        }
        return result;
    }

    public List<RecipeDTO> showSearchResultList(String searchWord) {
        return recipeRepository.showRecipeSearchList(searchWord);
    }

    public String retrieveCookingTime(int tempInput) {
        recipeRepository.retrieveCookingTime(tempInput);
        return "ok";
    }

    public String retrieveMealType(int tempInput) {
        recipeRepository.retrieveType(tempInput);
        return "ok";
    }

    public ClassificatorsResponse getSelectInput() {
        ClassificatorsResponse response = new ClassificatorsResponse();
        response.setIngredients(recipeRepository.getFullIngredientList());
        response.setUnits(recipeRepository.getFullUnitList());
        response.setCookingTime(recipeRepository.getFullCookingTimeList());
        response.setMealType(recipeRepository.getFullMealTypeList());
        return response;
    }

/*    public SignUp getSignUp() {
        System.out.println(signUpRepository.getOne(1));
        return signUpRepository.getOne(1);
    }*/

}
