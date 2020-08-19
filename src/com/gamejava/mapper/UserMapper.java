package com.gamejava.mapper;

import com.gamejava.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IRowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
