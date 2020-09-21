package com.example.demo.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeRowMapper implements RowMapper<TypeDTO> {

    @Override
    public TypeDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        TypeDTO tempOutput = new TypeDTO();
        tempOutput.setId(resultSet.getInt("id"));
        tempOutput.setType(resultSet.getString("type"));
        return tempOutput;
    }
}
