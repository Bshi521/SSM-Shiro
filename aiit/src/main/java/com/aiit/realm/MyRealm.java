package com.aiit.realm;

import com.aiit.pojo.Permission;
import com.aiit.pojo.Role;
import com.aiit.pojo.User;
import com.aiit.service.PermissionService;
import com.aiit.service.RoleService;
import com.aiit.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginname = (String) principalCollection.getPrimaryPrincipal();
//        查询角色信息
        Set<String> roles = roleService.listSysRolesByUserName(loginname);
        System.out.println(loginname);
//        查询权限信息
        Set<String> permissions = permissionService.listSysPermissionsByUserName(loginname);


        SimpleAuthorizationInfo s=new SimpleAuthorizationInfo();
        s.setRoles(roles);
        s.setStringPermissions(permissions);
        return s;
    }


//    身份验证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginname= (String)authenticationToken.getPrincipal();
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

//        将密码转换成字符串
        String password = new String(token.getPassword());
        System.out.println("============="+password);
//        System.out.println(loginname);

        User user = userService.getUserByName(loginname);
        System.out.println(user);
        if (user.getPassword()==null||!user.getPassword().equals(password)){
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(loginname, password, getName());

        return simpleAuthenticationInfo;
    }
}
