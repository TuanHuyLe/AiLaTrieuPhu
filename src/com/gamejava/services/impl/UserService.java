package com.gamejava.services.impl;

import com.gamejava.dao.IUserDAO;
import com.gamejava.model.User;
import com.gamejava.services.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserDAO userDAO;

    public UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User save(User user) {
        Integer userId = userDAO.save(user);
        return userDAO.findOne(userId);
    }

    @Override
    public User update(User user) {
        userDAO.update(user);
        return userDAO.findOne(user.getId());
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            userDAO.delete(id);
        }
    }

    @Override
    public User findByName(String name) {
        return userDAO.findByName(name);
    }
}
