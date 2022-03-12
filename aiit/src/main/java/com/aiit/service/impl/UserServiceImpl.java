package com.aiit.service.impl;

import com.aiit.dao.UserDao;
import com.aiit.pojo.User;
import com.aiit.service.UserService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User getUserByName(String loginname) {
        return userDao.getUserByName(loginname);
    }

    @Override
    public int saveUser(User user) {
//        第二次作业，加密处理
//        String salt= UUID.randomUUID().toString();//使用UUID随机生成盐值
//加密，使用MD5加密
        if ("zhangsan".equals(user.getLoginname())){
//            如果用户名为张三，就只使用MD5加密1024次
            String password = new Md5Hash(user.getPassword(), null, 1024).toBase64();
            user.setPassword(password);
            user.setSalt(null);
            return userDao.saveUser(user);
        }
        if ("lisi".equals(user.getLoginname())){
//            利用MD5，加盐 盐值为lisi，加密1024次得到密文
            String salt="lisi";
            String password=new Md5Hash(user.getPassword(),salt,1024).toBase64();
            user.setPassword(password);
            user.setSalt(salt);
            return userDao.saveUser(user);
        }
        if ("wangwu".equals(user.getLoginname())){
//            利用SHA-256 加密 ，加盐，加1024次
            String salt="wangwu";
            String password = new Sha256Hash(user.getPassword(), salt, 1024).toBase64();
            user.setPassword(password);
            user.setSalt(salt);
            return userDao.saveUser(user);
        }
//        其余人不加密
            return userDao.saveUser(user);
    }
}
