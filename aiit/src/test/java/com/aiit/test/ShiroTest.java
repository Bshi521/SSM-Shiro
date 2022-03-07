package com.aiit.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class ShiroTest {

    @Test
    public void test(){
        Factory<SecurityManager> factory=
                new IniSecurityManagerFactory("classpath:shiro.ini");
       SecurityManager securityManager= factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        System.out.println("判断用户是否登录："+subject.isAuthenticated());
    }
}
