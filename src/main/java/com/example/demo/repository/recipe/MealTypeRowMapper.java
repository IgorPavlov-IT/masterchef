package com.example.demo.repository.recipe;

import com.example.demo.controller.MealTypeResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MealTypeRowMapper implements RowMapper<MealTypeResponse> {

    @Override
    public MealTypeResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        MealTypeResponse tempOutput = new MealTypeResponse();
        tempOutput.setId(resultSet.getInt("id"));
        tempOutput.setName(resultSet.getString("name"));
        return tempOutput;
    }
}
