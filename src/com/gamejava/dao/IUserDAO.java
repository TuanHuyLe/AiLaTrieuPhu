package com.gamejava.dao;

import com.gamejava.model.User;

import java.util.List;

public interface IUserDAO extends IGenericDAO<User> {
    List<User> findAll();

    User findOne(int id);

    Integer save(User user);

    void update(User user);

    void delete(int id);
}
