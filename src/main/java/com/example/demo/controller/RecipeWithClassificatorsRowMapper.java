package com.example.demo.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// võimalik vaja teha uus DTO ning lisada sinna puuduvad (vajalikud) väljad, mida hetkel ei ole
// RecipeDTO
public class RecipeWithClassificatorsRowMapper implements RowMapper<RecipeWithClassificatorsDTO> {
    @Override
    public RecipeWithClassificatorsDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        RecipeWithClassificatorsDTO answer = new RecipeWithClassificatorsDTO();
        answer.setName(resultSet.getString("name"));
        answer.setCookingTime(resultSet.getString("cooking_time"));
        answer.setType(resultSet.getString("meal_type"));
        answer.setNotes(resultSet.getString("notes"));
        answer.setInstruction(resultSet.getString("instruction"));

        return answer;

    }

}

