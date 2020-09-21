package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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


    public void createRecipe (RecipeDTO newRecipeData) {
        String createRecipeString = "INSERT INTO recipe (name, cooking_time, type, notes, instruction)" +
                              "VALUES (:name, :cooking_time, :type, :notes, :instruction)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name" , newRecipeData.getName());
        paramMap.put("cooking_time", newRecipeData.getCookingTime());
        paramMap.put("type", newRecipeData.getType());
        paramMap.put("notes", newRecipeData.getNotes());
        paramMap.put("instruction", newRecipeData.getInstructions());
        jdbcTemplate.update(createRecipeString, paramMap);

       }

    public String retrieveCookingTime (int idCookingTime) {
        String retrieveCookingTimeInfo = "SELECT name FROM cooking_time WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", idCookingTime);

        return jdbcTemplate.queryForObject(retrieveCookingTimeInfo, paramMap, String.class);

    }

    public String retrieveType (int idMealType) {
        String retrieveMealTypeInfo = "SELECT name FROM meal_type WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", idMealType);

        return jdbcTemplate.queryForObject(retrieveMealTypeInfo, paramMap, String.class);

    }




}
