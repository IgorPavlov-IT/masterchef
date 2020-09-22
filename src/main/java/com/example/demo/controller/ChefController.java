package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RestController
public class ChefController {

    @Autowired
    private ChefService chefService;

    @PostMapping("masterchef/recipe/add")
    public void createRecipe(@RequestBody RecipeDTO newRecipeData) {
        chefService.createRecipe(newRecipeData);
    }

    @GetMapping("masterchef/recipe/display")
    public String showRecipe(@RequestBody int recipeID) {
        chefService.showRecipe(recipeID);
        return "OK";
    }

    @GetMapping("masterchef/recipe/{all}")
    public String showFullRecipeList() {
        chefService.showFullRecipeList();
        return "OK";
    }

    @Entity
    public class Recipe {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private int cookingTime;
        private int type;
        private String notes;
        //        private Object picture;
        private String instruction;

        public int getId() {
            return id;
        }

        public Recipe setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Recipe setName(String name) {
            this.name = name;
            return this;
        }

        public int getCookingTime() {
            return cookingTime;
        }

        public Recipe setCookingTime(int cookingTime) {
            this.cookingTime = cookingTime;
            return this;
        }

        public int getType() {
            return type;
        }

        public Recipe setType(int type) {
            this.type = type;
            return this;
        }

        public String getNotes() {
            return notes;
        }

        public Recipe setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public String getInstruction() {
            return instruction;
        }

        public Recipe setInstruction(String instruction) {
            this.instruction = instruction;
            return this;
        }
    }


//    @GetMapping ("masterchef/recipe/searchresult")
//    public String searchRecipeList
//    return = "OK";

//    @GetMapping ("masterchef/recipe/ingredientresult")
//    public String searchByIngredientRecipeList
//    return = "OK";

//    @GetMapping ("masterchef")

//


}





