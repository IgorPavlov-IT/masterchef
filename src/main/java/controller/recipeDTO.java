package controller;

public class recipeDTO {
    public int id;
    public String name;
//    public int quantity;
//    public String unit;
//    public String ingredient;
    public String cookingTime;
    public String type;
    public String notes;
    public String instruction;

    public int getId() {
        return id;
    }

    public recipeDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public recipeDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public recipeDTO setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public String getType() {
        return type;
    }

    public recipeDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public recipeDTO setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getInstruction() {
        return instruction;
    }

    public recipeDTO setInstruction(String instruction) {
        this.instruction = instruction;
        return this;
    }
}
