package com.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @RequestMapping("")
    public String index(){

        System.out.println("部门列表。。。");
        return "department";
    }

    @RequestMapping("/save")
    public String save(){

        System.out.println("部门新增。。。");
        return "department";
    }

    @RequestMapping("/edit")
    public String edit(){

        System.out.println("部门编辑。。。");
        return "department";
    }

    @RequestMapping("/delete")
    public String delete(){

        System.out.println("部门删除。。。");
        return "department";
    }

}
