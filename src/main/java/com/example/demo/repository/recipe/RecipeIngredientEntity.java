package com.example.demo.repository.recipe;

public class RecipeIngredientEntity {
    private Long id;
    private String name;
    private boolean showInRecipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShowInRecipe() {
        return showInRecipe;
    }

    public void setShowInRecipe(boolean showInRecipe) {
        this.showInRecipe = showInRecipe;
    }
}
