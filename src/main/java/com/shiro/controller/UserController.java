package com.shiro.controller;

import com.shiro.model.User;
import com.shiro.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest request, Model model){

        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
            user = new User();
            user.setUid(1);
            user.setPassword("123");
            user.setUsername("javen");
        }

        log.debug(user.toString());
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/showUser",method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.valueOf(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        return  "showUser";
    }
}
