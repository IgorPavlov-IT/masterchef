package com.example.demo.controller;

public class RecipeWithClassificatorsDTO {
    int id;
    String name;
    String cookingTime;
    String type;
    String notes;
//    Object picture;
    String instruction;

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
}
