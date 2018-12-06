package com.shiro.service.impl;

import com.shiro.dao.IRoleDao;
import com.shiro.model.Roles;
import com.shiro.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("rolesService")
public class RolesServiceImpl implements IRolesService {

   @Autowired
   private IRoleDao roleDao;

    @Override
    public List<String> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public List<String> getRolesById(int uid) {
        return roleDao.getRolesById(uid);
    }
}
