package com.example.demo.controller;

public class RecipeDTO {
    String name;
    int cookingTime;
    int type;
    String notes;
//    Object picture;
    String instruction;



//    public Object getPicture() {
//        return picture;
//    }
//
//    public RecipeDTO setPicture(Object picture) {
//        this.picture = picture;
//        return this;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
