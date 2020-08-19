package com.gamejava.services;

import com.gamejava.model.User;

import java.util.List;

public interface IUserService {
    User findOne(int id);

    List<User> findAll();

    User save(User user);

    User update(User user);

    void delete(int[] ids);
}
