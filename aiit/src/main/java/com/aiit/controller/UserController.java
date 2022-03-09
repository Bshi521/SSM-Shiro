package com.aiit.controller;

import com.aiit.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

//  跳转登录页面
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

//   登录功能实现
    @PostMapping("/doLogin")
    public String doLogin(User user){
//        System.out.println("用户信息："+user);
//    获取subject对象
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginname(), user.getPassword());

        subject.login(token);
        System.out.println(subject.hasRole("manager"));
        System.out.println(subject.isPermitted("manager:*"));
        return "redirect:/manager/allPaper";
    }


//    跳转用户注册页面
    @GetMapping("/regist")
    public String regist(){
        return "login/regist";
    }

//    实现注册功能
    @PostMapping("/doRegist")
    public Map<String,Object> doRegist(User user){
        return new HashMap<String, Object>();
    }
//    跳转管理员首页
    @GetMapping("/manager/allPaper")
    public String allPaper(){
        return "paper/allPaper";
    }

//    没有权限跳转的页面
    @GetMapping("/login/permsError")
    public String permsError(){
        return "/login/permsError";
    }
}
