package com.example.demo.repository.recipe;

import com.example.demo.controller.*;
import com.example.demo.controller.recipe.CookingTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RecipeRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int createRecipe(String name, int cookingTime, int type, String notes, String instruction, String selectedIngredients) {
        String createRecipeString = "INSERT INTO recipe (name, cooking_time_id, meal_type_id, notes, instruction, selected_ingredients) VALUES (:name, :cooking_time_id, :meal_type_id, :notes, :instruction, :selected_ingredients)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("cooking_time_id", cookingTime);
        paramMap.put("meal_type_id", type);
        paramMap.put("notes", notes);
        paramMap.put("instruction", instruction);
        paramMap.put("selected_ingredients", selectedIngredients);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(createRecipeString, new MapSqlParameterSource(paramMap), keyHolder);
        return (int) keyHolder.getKeys().get("id");
    }

    public int createRecipeIngredient(Integer recipeId, IngredientsDTO newRecipeData) {
        String sql = "INSERT INTO recipe_ingredient (recipe_id, ingredient_id, qty, unit_id, show_in_recipe) VALUES (:recipeId, :ingredientId, :qty, :unit_id, :show_in_recipe)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("recipeId", recipeId);
        paramMap.put("ingredientId", newRecipeData.getIngredient());
        paramMap.put("qty", newRecipeData.getQuantity());
        paramMap.put("unit_id", newRecipeData.getUnit());
        paramMap.put("show_in_recipe", newRecipeData.isShowInRecipe());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (int) keyHolder.getKeys().get("id");
    }

    public RecipeFullEntity getFullRecipe(int recipeID) {
        String sql = "SELECT recipe.name, cooking_time.name cooking_time_id, meal_type.name meal_type_id, recipe.notes, recipe.instruction FROM recipe " +
                "JOIN cooking_time ON recipe.cooking_time_id = cooking_time.id " +
                "JOIN meal_type ON recipe.meal_type_id = meal_type.id  WHERE recipe.id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", recipeID);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(RecipeFullEntity.class));
    }

    public List<IngredientFullEntity> getFullIngredients(int recipeID) {
        String sql = "SELECT ingredient.name, recipe_ingredient.qty, unit.name FROM recipe_ingredient " +
                "JOIN ingredient ON recipe_ingredient.ingredient_id = ingredient.id " +
                "JOIN unit ON recipe_ingredient.unit_id = unit.id WHERE recipe_ingredient.recipe_id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", recipeID);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(IngredientFullEntity.class));

    }


// TODO Delete later if not needed.
//    public RecipePageFullDTOResponseFromRepositoryToService showRecipe(int recipeID) {
//        String sql = "SELECT recipe.id, recipe.name, cooking_time.name cooking_time_id, meal_type.name meal_type_id, recipe.notes, recipe.instruction,  FROM recipe " +
//                     "JOIN cooking_time ON recipe.cooking_time_id = cooking_time.id "
//                     "LEFT JOIN recipe_ingredient ON recipe.id = recipe_ingredient.recipe_id"+
//                     "JOIN ingredient ON recipe_ingredient.ingredient_id = ingredient.id" +
//                     "JOIN meal_type ON recipe.meal_type_id = meal_type.id WHERE id = :id";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", recipeID);
//        RecipePageFullDTOResponseFromRepositoryToService temp = jdbcTemplate.query(sql, paramMap);
//
//        return temp;
//    }

    public List<RecipeWithClassificatorsDTO> showFullRecipeTable() {
        String showFullRecipeList = "SELECT recipe.id, recipe.name, cooking_time.name cooking_time_id, meal_type.name meal_type_id, recipe.notes, recipe.instruction " +
                "JOIN cooking_time ON recipe.cooking_time_id = cooking_time.id " +
                "JOIN meal_type ON recipe.meal_type_id = meal_type.id";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(showFullRecipeList, paramMap, new RecipeWithClassificatorsRowMapper());
    }

    public List<RecipeDTO> showRecipeSearchList(String searchWord) {
        String showSearchResultRecipeList = "SELECT * FROM recipe WHERE name = ilike :searchWord OR cooking_time = ilike :searchWord OR" +
                "type = ilike :searchWord OR notes = ilike :searchWord OR instruction ilike :searchWord";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchWord", "%" + searchWord + "%");
        List<RecipeDTO> recipeSearchData = jdbcTemplate.query(showSearchResultRecipeList, paramMap, new RecipeRowMapper());
        return recipeSearchData;
    }

    public String retrieveCookingTime(int idCookingTime) {
        String retrieveCookingTimeInfo = "SELECT name FROM cooking_time WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", idCookingTime);
        return jdbcTemplate.queryForObject(retrieveCookingTimeInfo, paramMap, String.class);
    }

    public String retrieveType(int idMealType) {
        String retrieveMealTypeInfo = "SELECT name FROM meal_type WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", idMealType);
        return jdbcTemplate.queryForObject(retrieveMealTypeInfo, paramMap, String.class);
    }

    public List<IngredientNameDTO> getFullIngredientList() {
        String sql = "SELECT * FROM ingredient ORDER BY name";
        List<IngredientNameDTO> resultList = jdbcTemplate.query(sql, new IngredientRowMapper());
        return resultList;
    }

    public List<UnitResponse> getFullUnitList() {
        String sql = "SELECT * FROM unit ORDER BY name";
        List<UnitResponse> resultList = jdbcTemplate.query(sql, new UnitRowMapper());
        return resultList;
    }

    public List<CookingTimeResponse> getFullCookingTimeList() {
        String sql = "SELECT * FROM cooking_time";
        List<CookingTimeResponse> resultList = jdbcTemplate.query(sql, new CookingTimeRowMapper());
        return resultList;
    }

    public List<MealTypeResponse> getFullMealTypeList() {
        String sql = "SELECT * FROM meal_type ORDER BY name";
        List<MealTypeResponse> resultList = jdbcTemplate.query(sql, new MealTypeRowMapper());
        return resultList;
    }

    public List<RecipeIngredientEntity> getRecipeIngredients(int recipeId) {
        String sql = "SELECT ri.id, name, show_in_recipe  FROM recipe_ingredient ri LEFT JOIN ingredient i on i.id = ri.ingredient_id " +
                "WHERE ri.recipe_id = :recipeId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("recipeId", recipeId);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(RecipeIngredientEntity.class));
    }
}
