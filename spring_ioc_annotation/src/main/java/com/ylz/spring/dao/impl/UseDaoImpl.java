package com.ylz.spring.dao.impl;

import com.ylz.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UseDaoImpl implements UserDao {
    public void saveUser() {
        System.out.println("保存成功");
    }
}
