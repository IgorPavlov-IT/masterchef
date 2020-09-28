package com.example.demo.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitRowMapper implements RowMapper<UnitResponse> {
    @Override
    public UnitResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        UnitResponse tempOutput = new UnitResponse();
        tempOutput.setId(resultSet.getInt("id"));
        tempOutput.setName(resultSet.getString("name"));
        return tempOutput;
    }
}

