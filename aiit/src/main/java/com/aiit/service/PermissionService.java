package com.aiit.service;

import java.util.Set;

public interface PermissionService {
    Set<String> listSysPermissionsByUserName(String loginname);
}
