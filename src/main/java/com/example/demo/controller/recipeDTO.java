package com.example.demo.controller;

public class RecipeDTO {

    String name;
    int cookingTime;
    int type;
    String notes;
    String picture;
    String instruction;

    public String getName() {
        return name;
    }

    public RecipeDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public RecipeDTO setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public int getType() {
        return type;
    }

    public RecipeDTO setType(int type) {
        this.type = type;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public RecipeDTO setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public RecipeDTO setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getInstruction() {
        return instruction;
    }

    public RecipeDTO setInstruction(String instruction) {
        this.instruction = instruction;
        return this;
    }
}
