package com.yhc.web.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.yhc.common.model.SysMenu;
import com.yhc.common.model.SysRole;
import com.yhc.common.model.SysUser;
import com.yhc.web.menu.service.SysMenuService;
import com.yhc.web.role.service.SysRoleService;
import com.yhc.web.user.service.UserService;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author StarZou
 * @since 2014年6月11日 上午11:35:28
 **/
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private SysRoleService roleService;

    @Resource
    private SysMenuService menuService;

    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());
        try {
        	final SysUser user = userService.selectByUsername(username);
            final List<SysRole> roleInfos = roleService.selectRolesByUserId(user.getId());
            for (SysRole role : roleInfos) {
                // 添加角色
                System.err.println(role);
                authorizationInfo.addRole(role.getEnname());

                final List<SysMenu> permissions = menuService.selectPermissionsByRoleId(role.getId());
                for (SysMenu permission : permissions) {
                    // 添加权限
                    System.err.println(permission);
                    authorizationInfo.addStringPermission(permission.getPermission());
                }
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        SysUser user=new SysUser();
        user.setLoginName(username);
        user.setPassword(password);
        // 通过数据库进行验证
        final SysUser authentication = userService.authentication(user);
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }

}
