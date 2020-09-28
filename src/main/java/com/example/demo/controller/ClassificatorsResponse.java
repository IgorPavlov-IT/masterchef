package com.example.demo.controller;

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

