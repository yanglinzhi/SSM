package com.ylz.spring.service.impl;

import com.ylz.spring.dao.UserDao;
import com.ylz.spring.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        userDao.saveUser();
    }
}
