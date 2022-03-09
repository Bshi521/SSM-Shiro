package com.aiit.dao;

import com.aiit.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleDao {
    Set<String> listSysRolesByUserName(String loginname);
}
