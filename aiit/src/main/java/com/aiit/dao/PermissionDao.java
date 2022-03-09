package com.aiit.dao;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionDao {
    Set<String> listSysPermissionsByUserName(String loginname);
}
