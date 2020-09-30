package com.example.demo.controller.recipe;

import com.example.demo.controller.IngredientsDTO;

import java.util.List;

//Delete later?
public class RecipePageIngredientDTORequest {
    List<IngredientTableDTO> recipeIngredientsList;

    public List<IngredientTableDTO> getRecipeIngredientsList() {
        return recipeIngredientsList;
    }

    public void setRecipeIngredientsList(List<IngredientTableDTO> recipeIngredientsList) {
        this.recipeIngredientsList = recipeIngredientsList;
    }
}
