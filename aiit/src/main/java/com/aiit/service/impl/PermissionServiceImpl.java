package com.aiit.service.impl;

import com.aiit.dao.PermissionDao;
import com.aiit.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
    @Override
    public Set<String> listSysPermissionsByUserName(String loginname) {
        System.out.println("===="+permissionDao.listSysPermissionsByUserName(loginname));
        return permissionDao.listSysPermissionsByUserName(loginname);
    }
}
