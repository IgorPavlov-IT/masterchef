package com.example.demo.repository.recipe;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowRecipeRowMapper implements RowMapper<RecipeFullEntity> {
    @Override
    public RecipeFullEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        RecipeFullEntity tempOutput = new RecipeFullEntity();
        tempOutput.setName(resultSet.getString("name"));
        tempOutput.setCookingTime(resultSet.getString("cooking_time"));
        tempOutput.setType(resultSet.getString("meal_type"));
        tempOutput.setNotes(resultSet.getString("notes"));
        tempOutput.setInstruction(resultSet.getString("instruction"));
        return tempOutput;
    }
}


