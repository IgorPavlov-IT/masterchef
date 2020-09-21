package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChefRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void createRecipe(RecipeDTO newRecipeData) {
        String createRecipeString = "INSERT INTO recipe (name, cooking_time, type, notes, instruction)" +
                "VALUES (:name, :cooking_time, :type, :notes, :instruction)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", newRecipeData.getName());
        paramMap.put("cooking_time", newRecipeData.getCookingTime());
        paramMap.put("type", newRecipeData.getType());
        paramMap.put("notes", newRecipeData.getNotes());
        paramMap.put("instruction", newRecipeData.getInstruction());
        jdbcTemplate.update(createRecipeString, paramMap);

    }

    public RecipeDTO showRecipe (int recipeID) {
        String showRecipeString = "SELECT * FROM recipe WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", recipeID);
        RecipeDTO recipeDTO = jdbcTemplate.queryForObject(showRecipeString, paramMap, new RecipeRowMapper());
        //jdbcTemplate.queryForList(showRecipeString, paramMap, String.class) - näide stringilistist.
        return recipeDTO;

    }

    public List<RecipeDTO> showFullRecipeTable () {
        String showFullRecipeList = "SELECT * FROM recipe";
        Map<String, Object> paramMap = new HashMap<>();
        List<RecipeDTO> recipeDTOData = jdbcTemplate.query(showFullRecipeList, paramMap, new RecipeRowMapper());
        return recipeDTOData;
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


}
