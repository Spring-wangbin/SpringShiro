package com.shiro.service.impl;

import com.shiro.dao.IUserDao;
import com.shiro.model.User;
import com.shiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User getUserById(int uid) {
        return userDao.getById(uid);
    }
}
