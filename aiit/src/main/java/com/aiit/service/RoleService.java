package com.aiit.service;

import com.aiit.pojo.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Set<String> listSysRolesByUserName(String loginname);
}
