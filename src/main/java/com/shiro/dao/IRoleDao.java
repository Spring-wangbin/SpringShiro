package com.shiro.dao;

import com.shiro.model.Roles;
import com.shiro.model.User;

import java.util.List;

public interface IRoleDao {
    public List<String> getAllRoles();

    public List<String> getRolesById(int rid);
}
