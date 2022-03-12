package com.aiit.service;

import com.aiit.pojo.User;

public interface UserService {
    User getUserByName(String loginname);

    int saveUser(User user);
}
