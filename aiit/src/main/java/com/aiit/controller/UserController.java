package com.aiit.controller;

import com.aiit.dao.UserDao;
import com.aiit.pojo.User;
import com.aiit.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
//  跳转登录页面
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

//   登录功能实现
    @PostMapping("/doLogin")
    public ModelAndView doLogin(User user){
        ModelAndView mav=new ModelAndView();
//        System.out.println("用户信息："+user);
//    获取subject对象
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginname(), user.getPassword());

        subject.login(token);
//        return "redirect:/manager/allPaper";
        if (subject.hasRole("user")){
            mav.addObject("title","普通产品");
            mav.setViewName("login/product");
            return mav;
        }
        if (subject.hasRole("vip")){
            mav.addObject("title","普通产品");
            mav.setViewName("login/product");
            return mav;
        }
        if (subject.hasRole("vvip")){
            mav.addObject("title","vip产品");
            mav.setViewName("login/product");
            return mav;
        }
        return mav;
    }


//    跳转用户注册页面
    @GetMapping("/regist")
    public String regist(){
        return "login/regist";
    }

//    实现注册功能
    @PostMapping("/doRegist")
    public ModelAndView doRegist(User user){
        ModelAndView mav=new ModelAndView();
        int i = userService.saveUser(user);
        System.out.println(i);
        if (i==1){
            mav.setViewName("login/login");
        }
        else{
            mav.addObject("msg","注册失败");
//            mav.setViewName("forward:/regist");
        }
        return mav;
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

//    退出登录
    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login/login";
    }

//    登录成功后跳转product页面
    @GetMapping("/product")
    public String product(){
        return "login/product";
    }
}
