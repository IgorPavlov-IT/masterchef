package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChefRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createSqlUser(String firstName, String lastName, String username, String password) {
        String sql = "INSERT INTO sign_up (first_name, last_name, username, password) values (:firstName, :lastName, :username, :password)";    //koolon viitab väljapoole SQL'i, viitab Javale
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        paramMap.put("username", username);
        paramMap.put("password", password);
        jdbcTemplate.update(sql, paramMap);
    }

/*    public void createRecipe(RecipeDTO newRecipeData) {       //See on eelmine versioon ilma ingredients'deta
        String createRecipeString = "INSERT INTO recipe (name, cooking_time_id, meal_type_id, notes, instruction) VALUES (:name, :cooking_time_id, :meal_type_id, :notes, :instruction)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", newRecipeData.getName());
        paramMap.put("cooking_time_id", newRecipeData.getCookingTime());
        paramMap.put("meal_type_id", newRecipeData.getType());
        paramMap.put("notes", newRecipeData.getNotes());
        paramMap.put("instruction", newRecipeData.getInstruction());
        jdbcTemplate.update(createRecipeString, paramMap);
            }*/

    public int createRecipe(RecipeWithIngredientsDTO newRecipeData) {
        String createRecipeString = "INSERT INTO recipe (name, cooking_time_id, meal_type_id, notes, instruction) VALUES (:name, :cooking_time_id, :meal_type_id, :notes, :instruction)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", newRecipeData.getName());
        paramMap.put("cooking_time_id", newRecipeData.getCookingTime());
        paramMap.put("meal_type_id", newRecipeData.getType());
        paramMap.put("notes", newRecipeData.getNotes());
        paramMap.put("instruction", newRecipeData.getInstruction());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(createRecipeString, new MapSqlParameterSource(paramMap), keyHolder);
        return (int) keyHolder.getKeys().get("id");
    }

    public Integer createRecipe(String name, Integer cookingTime, String instruction, Integer type,  String notes) {
        String sql = "INSERT INTO () values ()";
        return 0;
    }

    public int createRecipeIngredient(Integer recipeId, IngredientsDTO newRecipeData) {
        String sql = "INSERT INTO recipe_ingredient (recipe_id, ingredient_id, qty, unit) VALUES (:recipeId, :ingredientId, :qty, :unit)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("recipeId", recipeId);
        paramMap.put("ingredientId", newRecipeData.getIngredient());
        paramMap.put("qty", newRecipeData.getQuantity());
        paramMap.put("unit", newRecipeData.getUnit());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (int) keyHolder.getKeys().get("id");
    }

    public RecipeDTO showRecipe(int recipeID) {
        String showRecipeString = "SELECT * FROM recipe WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", recipeID);
        RecipeDTO RecipeDTO = jdbcTemplate.queryForObject(showRecipeString, paramMap, new RecipeRowMapper());
        //jdbcTemplate.queryForList(showRecipeString, paramMap, String.class) - näide stringilistist.
        return RecipeDTO;
    }

    public List<RecipeWithClassificatorsDTO> showFullRecipeTable() {
        String showFullRecipeList = "SELECT recipe.id, recipe.name, cooking_time.name cooking_time_id, meal_type.name meal_type_id, recipe.notes, recipe.instruction FROM recipe " +
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

    public List<IngredientNameDTO> getIngredientList() {
        String sql = "SELECT * FROM ingredient ORDER BY name";
        List<IngredientNameDTO> resultList = jdbcTemplate.query(sql, new IngredientRowMapper());
        return resultList;
    }

    public List<UnitResponse> getUnitList() {
        String sql = "SELECT * FROM unit ORDER BY name";
        List<UnitResponse> resultList = jdbcTemplate.query(sql, new UnitRowMapper());
        return resultList;
    }

    public List<CookingTimeResponse> getCookingTimeList() {
        String sql = "SELECT * FROM cooking_time";
        List<CookingTimeResponse> resultList = jdbcTemplate.query(sql, new CookingTimeRowMapper());
        return resultList;
    }

    public List<MealTypeResponse> getMealTypeList() {
        String sql = "SELECT * FROM meal_type ORDER BY name";
        List<MealTypeResponse> resultList = jdbcTemplate.query(sql, new MealTypeRowMapper());
        return resultList;
    }
}
