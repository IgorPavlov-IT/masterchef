
package com.example.demo.controller;

public class CookingTimeDTO {
    int id;
    String cookingTime;

    public int getId() {
        return id;
    }

    public CookingTimeDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public CookingTimeDTO setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }
}

