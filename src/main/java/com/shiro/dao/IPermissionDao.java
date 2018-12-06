package com.shiro.dao;

import com.shiro.model.Permission;
import com.shiro.model.User;

import java.util.List;

public interface IPermissionDao {

    public int save(Permission permission);

    public List<Permission> getAllPermission();
}
