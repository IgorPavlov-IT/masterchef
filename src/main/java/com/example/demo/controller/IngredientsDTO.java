package com.example.demo.controller;

public class IngredientsDTO {
    int ingredient;     //int, kui teeme select box'i
    int quantity;
    int unit;      //int, kui teeme select box'i

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
