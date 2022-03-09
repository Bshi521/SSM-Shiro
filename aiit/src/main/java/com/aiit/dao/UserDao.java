package com.aiit.dao;

import com.aiit.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserByName(String loginname);
}
