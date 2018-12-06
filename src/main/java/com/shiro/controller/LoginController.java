package com.shiro.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request){
        System.out.println("认证失败请求方法...");

        //如果登录失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全名
        String execptionClassName = (String) request.getAttribute("shiroLoginFailure");

        if(execptionClassName != null){
            if(UnknownAccountException.class.getName().equals(execptionClassName)){
                model.addAttribute("errorMsg","账号不存在");
            }else if(IncorrectCredentialsException.class.getName().equals(execptionClassName)){
                model.addAttribute("errorMsg","用户名/密码错误");
            }else {
                model.addAttribute("errorMsg","其他异常信息");
            }
        }

        //此方法不处理登录成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        //登录失败返回到初始页面
        return "forward:/index.jsp";
    }

    @RequestMapping("/logout")
    public String logout(){

        System.out.println("logout...");
        return "index";
    }
}
