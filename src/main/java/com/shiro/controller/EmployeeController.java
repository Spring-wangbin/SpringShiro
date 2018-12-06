package com.shiro.controller;

import com.shiro.realm.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("")
    @RequiresPermissions("employee:list")
    @PermissionName("员工列表")
    public String index(){

        System.out.println("员工列表。。。");
        return "employee";
    }

    @RequestMapping("/save")
    @RequiresPermissions("employee:save")
    @PermissionName("员工新增")
    public String save(){

        System.out.println("员工新增。。。");
        return "employee";
    }

    @RequestMapping("/edit")
    @RequiresPermissions("employee:edit")
    @PermissionName("员工编辑")
    public String edit(){

        System.out.println("员工编辑。。。");
        return "employee";
    }

    @RequestMapping("/delete")
    @RequiresPermissions("employee:delete")
    @PermissionName("员工删除")
    public String delete(){

        System.out.println("员工删除。。。");
        return "employee";
    }

}
