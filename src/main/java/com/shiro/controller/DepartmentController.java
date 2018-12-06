package com.shiro.controller;

import com.shiro.realm.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @RequestMapping("")
    @RequiresPermissions("department:list")
    @PermissionName("部门列表")
    public String index(){

        System.out.println("部门列表。。。");
        return "department";
    }

    @RequestMapping("/save")
    @RequiresPermissions("department:save")
    @PermissionName("部门新增")
    public String save(){

        System.out.println("部门新增。。。");
        return "department";
    }

    @RequestMapping("/edit")
    @RequiresPermissions("department:edit")
    @PermissionName("部门编辑")
    public String edit(){

        System.out.println("部门编辑。。。");
        return "department";
    }

    @RequestMapping("/delete")
    @RequiresPermissions("department:delete")
    @PermissionName("部门删除")
    public String delete(){

        System.out.println("部门删除。。。");
        return "department";
    }

}
