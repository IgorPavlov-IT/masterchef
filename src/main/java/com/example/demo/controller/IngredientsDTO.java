package com.example.demo.controller;

public class IngredientsDTO {
    int ingredient;
    int quantity;
    int unit;
    boolean showInRecipe;

    public boolean isShowInRecipe() {
        return showInRecipe;
    }

    public void setShowInRecipe(boolean showInRecipe) {
        this.showInRecipe = showInRecipe;
    }

    public int getIngredient() {
        return ingredient;
    }

    public void setIngredient(int ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
