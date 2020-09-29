package com.example.demo.repository.recipe;

import com.example.demo.controller.CookingTimeResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CookingTimeRowMapper implements RowMapper<CookingTimeResponse> {
    @Override
    public CookingTimeResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        CookingTimeResponse tempOutput = new CookingTimeResponse();
        tempOutput.setId(resultSet.getInt("id"));
        tempOutput.setName(resultSet.getString("name"));
        return tempOutput;
    }
}
