package com.gamejava.dao.impl;

import com.gamejava.dao.IUserDAO;
import com.gamejava.mapper.UserMapper;
import com.gamejava.model.User;

import java.util.List;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return query(sql, new UserMapper());
    }

    @Override
    public User findOne(int id) {
        String sql = "select * from user where id = ?";
        List<User> list = query(sql, new UserMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Integer save(User user) {
        String sql = "insert into user(name) values(?)";
        return insert(sql, user.getName());
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ? where id = ?";
        update(sql, user.getName(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        update(sql, id);
    }
}
