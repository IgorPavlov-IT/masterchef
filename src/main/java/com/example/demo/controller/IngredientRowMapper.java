package com.example.demo.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientRowMapper implements RowMapper<IngredientNameDTO> {
    @Override
    public IngredientNameDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        IngredientNameDTO tempOutput = new IngredientNameDTO();
        tempOutput.setId(resultSet.getInt("id"));
        tempOutput.setName(resultSet.getString("name"));
        return tempOutput;
    }
}


