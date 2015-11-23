package com.yhc.web.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import com.yhc.common.config.BlGlobalVariable;
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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    	//获取基于用户名和密码的令牌  
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
        //两个token的引用都是一样的
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        String username = String.valueOf(token.getPrincipal());
        SimpleAuthenticationInfo authenticationInfo=null;
        try {
        	// 通过数据库进行验证
            final SysUser user = userService.selectByUsername(username);
            if (user == null) {
                throw new AuthenticationException("用户名或密码错误.");
            }
//            if(Boolean.TRUE.equals(user.getLocked())) {  
//                throw new LockedAccountException(); //帐号锁定  
//            } 
//            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
          
            //交给AuthenticatingRealm使用LimitRetryHashedMatcher进行密码匹配
            authenticationInfo = new SimpleAuthenticationInfo(  
            		user.getLoginName(), //用户名  
            		user.getPassword(), //密码  
                    ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt  
                    getName()  //realm name  
            );  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
        return authenticationInfo;
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
     SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
     clearCachedAuthorizationInfo(principals);
    }
    
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
//    	Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//        if (cache != null) {
//        for (Object key : cache.keys()) {
//        cache.remove(key);
//        }
//        }
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
