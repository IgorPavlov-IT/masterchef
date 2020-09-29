package com.example.demo.controller;

public class RecipeWithClassificatorsDTO {
    private int id;
    private String name;
    private String cookingTime;
    private String type;
    private String notes;
//    Object picture;
    private String instruction;
    private String ingredients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public RecipeWithClassificatorsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public RecipeWithClassificatorsDTO setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public String getType() {
        return type;
    }

    public RecipeWithClassificatorsDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public RecipeWithClassificatorsDTO setNotes(String notes) {
        this.notes = notes;
        return this;
    }

//    public Object getPicture() {
//        return picture;
//    }
//
//    public RecipeDTO setPicture(Object picture) {
//        this.picture = picture;
//        return this;
//    }

    public String getInstruction() {
        return instruction;
    }

    public RecipeWithClassificatorsDTO setInstruction(String instruction) {
        this.instruction = instruction;
        return this;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
