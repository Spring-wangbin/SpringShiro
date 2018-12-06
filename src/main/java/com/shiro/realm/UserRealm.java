package com.shiro.realm;

import com.shiro.model.User;
import com.shiro.service.IPermissionService;
import com.shiro.service.IRolesService;
import com.shiro.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRolesService rolesService;
    @Autowired
    private IPermissionService permissionService;

    //授权

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限授予");
        User user = (User) principals.getPrimaryPrincipal();
        List<String> permissions = new ArrayList<String>();
        List<String> roles = new ArrayList<String>();
        if(user != null){
            if("admin".equals(user.getUsername())){
                permissions.add("*:*");
                roles = rolesService.getAllRoles();
            }else {
                roles = rolesService.getRolesById(user.getUid());
                permissions = permissionService.getPsemissionByUserid(user.getUid());
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        info.addRoles(roles);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //从token中获取登录的用户名，查询数据库返回用户信息
        String username = (String) token.getPrincipal();
        User user = userService.getUserByUsername(username);

        if(user == null){
            return null;
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        System.out.println("认证成功："+info);
        return info;
    }

    @Override
    public String getName() {
        return "userRealm";
    }

    public void clearCache(){
        /*清空缓存*/
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
