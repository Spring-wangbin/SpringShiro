package com.shiro.service.impl;

import com.shiro.dao.IPermissionDao;
import com.shiro.model.Permission;
import com.shiro.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private IPermissionDao permissionDao;

    @Override
    public int save(Permission permission) {
        return permissionDao.save(permission);
    }

    @Override
    public List<Permission> getAllPermission() {
        return permissionDao.getAllPermission();
    }
}
