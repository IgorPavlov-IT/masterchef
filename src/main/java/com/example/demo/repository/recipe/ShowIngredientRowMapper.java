package com.example.demo.repository.recipe;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowIngredientRowMapper implements RowMapper<IngredientFullEntity> {
    @Override
    public IngredientFullEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        IngredientFullEntity tempOutput = new IngredientFullEntity();
        tempOutput.setName(resultSet.getString("ingredient_name"));
        tempOutput.setQuantity(resultSet.getInt("qty"));
        tempOutput.setUnit(resultSet.getString("ingredient_unit"));
        return tempOutput;
    }
}

