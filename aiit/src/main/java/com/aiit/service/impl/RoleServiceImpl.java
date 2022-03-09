package com.aiit.service.impl;

import com.aiit.dao.RoleDao;
import com.aiit.pojo.Role;
import com.aiit.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao sysRoleDao;
    @Override
    public Set<String> listSysRolesByUserName(String loginname) {
        return sysRoleDao.listSysRolesByUserName(loginname);
    }
}
