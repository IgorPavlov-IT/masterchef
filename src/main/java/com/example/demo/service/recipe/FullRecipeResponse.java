package com.example.demo.service.recipe;

import com.example.demo.repository.recipe.IngredientFullEntity;
import com.example.demo.repository.recipe.RecipeFullEntity;

import java.util.ArrayList;
import java.util.List;

public class FullRecipeResponse {
    private final String name;
    private final String cookingTime;
    private final String type;
    private final String notes;
    private final String instruction;
    private final List<IngredientFullResponse> ingredients = new ArrayList<>();

    public FullRecipeResponse(RecipeFullEntity recipeEntity, List<IngredientFullEntity> ingredientEntityList) {
        this.name = recipeEntity.getName();
        this.cookingTime = recipeEntity.getCookingTime();
        this.type = recipeEntity.getType();
        this.notes = recipeEntity.getNotes();
        this.instruction = recipeEntity.getInstruction();
        for (IngredientFullEntity ingredientFullEntity : ingredientEntityList) {
            ingredients.add(new IngredientFullResponse(ingredientFullEntity));
        }
    }

    public String getName() {
        return name;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public String getType() {
        return type;
    }

    public String getNotes() {
        return notes;
    }

    public String getInstruction() {
        return instruction;
    }

    public List<IngredientFullResponse> getIngredients() {
        return ingredients;
    }

    public static class IngredientFullResponse {
        private final String name;
        private final Integer quantity;
        private final String unit;

        public IngredientFullResponse(IngredientFullEntity ingredientFullEntity) {
            this.name = ingredientFullEntity.getName();
            this.quantity = ingredientFullEntity.getQuantity();
            this.unit = ingredientFullEntity.getUnit();
        }

        public String getName() {
            return name;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public String getUnit() {
            return unit;
        }
    }
}
