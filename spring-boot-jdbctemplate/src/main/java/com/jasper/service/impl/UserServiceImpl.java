package com.jasper.service.impl;

import com.jasper.dao.UserDao;
import com.jasper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jasper on 2017/2/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void create(Integer id, String name, Integer age) {
        userDao.create(id, name, age);
    }

    public void deleteByName(String name) {
        userDao.deleteByName(name);
    }

    public Integer getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }
}
