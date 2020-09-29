package com.example.demo.controller.recipe;

import com.example.demo.controller.CookingTimeResponse;
import com.example.demo.controller.IngredientNameDTO;
import com.example.demo.controller.MealTypeResponse;
import com.example.demo.controller.UnitResponse;

import java.util.List;

public class ClassificatorsResponse {
    private List<IngredientNameDTO> ingredients;
    private List<UnitResponse> units;
    private List<CookingTimeResponse> cookingTime;
    private List<MealTypeResponse> mealType;

    public List<IngredientNameDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientNameDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public List<UnitResponse> getUnits() {
        return units;
    }

    public void setUnits(List<UnitResponse> units) {
        this.units = units;
    }

    public List<CookingTimeResponse> getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(List<CookingTimeResponse> cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<MealTypeResponse> getMealType() {
        return mealType;
    }

    public void setMealType(List<MealTypeResponse> mealType) {
        this.mealType = mealType;
    }
}

