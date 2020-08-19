package com.gamejava.adapter.actions;

import com.gamejava.dao.impl.UserDAO;
import com.gamejava.model.User;
import com.gamejava.services.IUserService;
import com.gamejava.services.impl.UserService;

import java.util.List;

public class Account {
    private IUserService userService;

    public Account() {
        userService = new UserService(new UserDAO());
    }

    public boolean checkLogin(String name, String password) {
        List<User> list = userService.findAll();
        for (User user : list) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean registerAccount(String name, String password) {
        User user = userService.findByName(name);
        if (user == null) {
            user = new User();
            user.setName(name);
            user.setPassword(password);
            userService.save(user);
            return true;
        }
        return false;
    }
}
