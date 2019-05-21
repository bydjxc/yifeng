package com.yifeng.yfcore.model;

import com.yifeng.yfcore.service.YfUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 16:11 2019/3/19
 * @Modified By
 * @Version 1.0
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private YfUserService userService;

    /**
     * 授权
     *
     * 授权的方法是在碰到<shiro:hashPermission>标签的时候调用的，
     * 它回去检测shiro框架中的权限是否包含有该标签的name值，
     * 如果有，里面的内容显示，否则不显示(这就完成了对于权限的认证)
     *
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取session中的用户
        YfUser user = (YfUser) principalCollection.fromRealm(this.getClass().getName()).iterator().next();

        List<String> permissions = new ArrayList<>();
        Set<YfRole> roles = user.getRoles();
        if (roles.size() > 0) {
            for (YfRole role : roles) {
                Set<YfAcl> acls = role.getAcls();
                if (acls.size() > 0) {
                    for (YfAcl acl : acls) {
                        permissions.add(acl.getAclName());
                    }
                }
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 认证。登录
     * 这个方法主要是做等登录验证，说白了就是去数据库里面校验用户是否存在
     * 注意这里不需要进行密码校验，shiro会帮我们做密码校验
     *
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        try{
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            String username = token.getUsername();

            YfUser user = userService.findUserByName(username);

            if (user != null){
                //若用户存在，将此用户存放到登录认证info中，无需自己做密码对比，shiro会为我们进行密码对比校验
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
                //放入shiro 调用CredentialsMatcher检验密码
                return info;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
