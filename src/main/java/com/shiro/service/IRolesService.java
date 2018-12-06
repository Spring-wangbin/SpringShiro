package com.shiro.service;

import com.shiro.model.Permission;
import com.shiro.model.Roles;

import java.util.List;

public interface IRolesService {
    public List<String> getAllRoles();

    public List<String> getRolesById(int uid);
}
