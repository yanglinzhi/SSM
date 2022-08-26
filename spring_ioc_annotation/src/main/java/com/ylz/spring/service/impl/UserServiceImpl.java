package com.ylz.spring.service.impl;

import com.ylz.spring.dao.UserDao;
import com.ylz.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public void saveUser() {
        userDao.saveUser();
    }
}
