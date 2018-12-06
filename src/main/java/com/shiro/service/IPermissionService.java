package com.shiro.service;

import com.shiro.model.Permission;

import java.util.List;

public interface IPermissionService {
    public int save(Permission permission);
    public List<Permission> getAllPermission();
}
