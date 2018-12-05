package com.shiro.dao;

import com.shiro.model.User;

public interface IUserDao {
    public User getById(int uid);
    public User getUserByUsername(String username);
}
