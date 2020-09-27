package com.example.demo.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// võimalik vaja teha uus DTO ning lisada sinna puuduvad (vajalikud) väljad, mida hetkel ei ole
// RecipeDTO
public class RecipeRowMapper implements RowMapper<RecipeDTO> {
    @Override
    public RecipeDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        RecipeDTO answer = new RecipeDTO();
        answer.setName(resultSet.getString("name"));
        answer.setCookingTime(resultSet.getInt("cooking_time_id"));
        answer.setType(resultSet.getInt("meal_type_id"));
//        answer.set
        answer.setNotes(resultSet.getString("notes"));
        answer.setInstruction(resultSet.getString("instruction"));
        return answer;
    }
}

