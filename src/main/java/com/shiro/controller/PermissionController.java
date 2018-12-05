package com.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
@RequestMapping("/permission")
public class PermissionController {


    private RequestMappingHandlerMapping rmhm;

    @RequestMapping("/reload")
    public String reload(){
        return "list";
    }
}
