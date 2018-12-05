package com.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("")
    public String index(){

        System.out.println("员工列表。。。");
        return "employee";
    }

    @RequestMapping("/save")
    public String save(){

        System.out.println("员工新增。。。");
        return "employee";
    }

    @RequestMapping("/edit")
    public String edit(){

        System.out.println("员工编辑。。。");
        return "employee";
    }

    @RequestMapping("/delete")
    public String delete(){

        System.out.println("员工删除。。。");
        return "employee";
    }

}
