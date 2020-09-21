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
        answer.setCookingTime(resultSet.getInt("cooking_time"));
        answer.setType(resultSet.getInt("type"));
        answer.setNotes(resultSet.getString("notes"));
        answer.setInstruction(resultSet.getString("instruction"));

        return answer;

    }

}

