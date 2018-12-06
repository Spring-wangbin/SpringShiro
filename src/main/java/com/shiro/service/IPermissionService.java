package com.shiro.service;

import com.shiro.model.Permission;

import java.util.List;

public interface IPermissionService {
    public int save(Permission permission);
    public List<String> getAllPermission();
    public List<String> getPsemissionByUserid(int uid);
}
