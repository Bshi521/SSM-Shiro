package com.aiit.service.impl;

import com.aiit.dao.UserDao;
import com.aiit.pojo.User;
import com.aiit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User getUserByName(String loginname) {
        return userDao.getUserByName(loginname);
    }
}
