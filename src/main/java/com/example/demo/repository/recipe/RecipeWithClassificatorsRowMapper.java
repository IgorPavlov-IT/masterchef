package com.example.demo.repository.recipe;

import com.example.demo.controller.RecipeWithClassificatorsDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// võimalik vaja teha uus DTO ning lisada sinna puuduvad (vajalikud) väljad, mida hetkel ei ole
// RecipeDTO
public class RecipeWithClassificatorsRowMapper implements RowMapper<RecipeWithClassificatorsDTO> {
    @Override
    public RecipeWithClassificatorsDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        RecipeWithClassificatorsDTO answer = new RecipeWithClassificatorsDTO();
        answer.setId(resultSet.getInt("id"));
        answer.setName(resultSet.getString("name"));
        answer.setCookingTime(resultSet.getString("cooking_time_id"));
        answer.setType(resultSet.getString("meal_type_id"));
        answer.setNotes(resultSet.getString("notes"));
        answer.setInstruction(resultSet.getString("instruction"));

        return answer;

    }

}

