package com.shiro.controller;

import com.shiro.model.Permission;
import com.shiro.realm.PermissionName;
import com.shiro.service.IPermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class PermissionController {

    //springmvc在启动的时候 将所有贴requestmapping标签的方法封装起来
    @Autowired
    private RequestMappingHandlerMapping rmhm;

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/reload")
    public String reload(){

        //加载系统中所有的权限表达式，放入数据库

        //0:过滤掉已经加载的权限
        List<String> al = permissionService.getAllPermission();

        //1.获取controller中所有带有requestMapper标签的方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods =  rmhm.getHandlerMethods();
        Collection<HandlerMethod> methods = handlerMethods.values();
        for (HandlerMethod method:methods) {
            //2.遍历所有的方法，判断当前方法是否贴有@requiresPermission注解标签
            RequiresPermissions annotation = method.getMethodAnnotation(RequiresPermissions.class);

            if(annotation == null){
                continue;
            }

            if(al.contains(annotation.value()[0])) continue;

            Permission permission = new Permission();
            permission.setPname(method.getMethodAnnotation(PermissionName.class).value());
            permission.setPmark(annotation.value()[0]);
            permissionService.save(permission);
        }

        //3.如果有，解析权限表达式，封装成功permission对象保存到数据库
        return "main";
    }
}
