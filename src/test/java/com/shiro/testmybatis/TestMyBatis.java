package com.shiro.testmybatis;

import javax.annotation.Resource;

import com.shiro.model.Permission;
import com.shiro.service.IPermissionService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.shiro.model.User;
import com.shiro.service.IUserService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
//    private ApplicationContext ac = null;
    @Resource
    private IUserService userService = null;

    @Resource
    private IPermissionService permissionService;

  @Before
  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
  }

    @Test
    public void test1() {
        User user = userService.getUserById(2);
        System.out.println(user.getUsername());
        logger.info("值："+user.getUsername());
        logger.info(JSON.toJSONString(user));
    }

    @Test
    public void test2(){
        Permission permission = new Permission();
        permission.setPname("部门更新");
        permission.setPmark("department:edit");

        int a = permissionService.save(permission);
        System.out.println(a);
    }


    @Test
    public void test3(){

        List<String> psemissionByUserid = permissionService.getPsemissionByUserid(1);
        System.out.println(psemissionByUserid);

    }
}