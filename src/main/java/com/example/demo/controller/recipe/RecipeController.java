package com.example.demo.controller.recipe;

import com.example.demo.controller.RecipeWithClassificatorsDTO;
import com.example.demo.service.recipe.FullRecipeResponse;
import com.example.demo.service.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RecipeController {

    @Autowired
    private RecipeService chefService;

    // web:   http://localhost:8080/masterchef/recipe/add   createRecipe.html
    @PostMapping("masterchef/recipe/add")
    public void createRecipe(@RequestBody RecipeWithIngredientsRequest newRecipeData, String selectedIngredients) {
        chefService.createRecipe(newRecipeData, selectedIngredients);
    }

/*    @GetMapping("masterchef/user")
    public UserDTO getUser() {
        return new UserDTO(chefService.getSignUp());

    }*/  // web: http://localhost:8080/masterchef/user


    @GetMapping("masterchef/recipe/display")

    public FullRecipeResponse showRecipe(@RequestParam("r_id") int recipeID) {

        return chefService.showRecipe(recipeID);
    }   // web: http://localhost:8080/masterchef/recipe/display

    @GetMapping("masterchef/recipe/all")
    public List<RecipeWithClassificatorsDTO> showFullRecipeList() {
        return chefService.showFullRecipeList();
    }   // web:   http://localhost:8080/masterchef/recipe/all

/*    @GetMapping("masterchef/recipe/add")
    public List<IngredientNameDTO> loadIngredientList() {
       return chefService.getIngredientList();
    }   // web:   http://localhost:8080/masterchef/recipe/add       createRecipe.html*/

    @GetMapping("masterchef/recipe/add")
    public ClassificatorsResponse loadIngredientList() {
        return chefService.getSelectInput();
    }   // web:   http://localhost:8080/masterchef/recipe/add       createRecipe.html

//    @GetMapping ("masterchef/recipe/searchresult")
//    public String searchRecipeList
//    return = "OK";


//    @GetMapping ("masterchef/recipe/ingredientresult")
//    public String searchByIngredientRecipeList
//    return = "OK";

//    @GetMapping ("masterchef")

}






