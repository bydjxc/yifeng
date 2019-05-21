package com.yifeng.yfcore.model;

import com.yifeng.yfcore.common.YfApplicationContext;
import com.yifeng.yfcore.utils.PasswordUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 16:57 2019/3/20
 * @Modified By
 * @Version 1.0
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        //用户输入的密码
        String inPass = new String(token1.getPassword());
        //数据库中的密码
        String dbPass = (String) info.getCredentials();
        //从AuthenticationInfo中获取user信息
        YfUser user = (YfUser) info.getPrincipals().getPrimaryPrincipal();
        //YfUser yfUser = (YfUser) info.getPrincipals().asList().get(0);

        PasswordUtil util = YfApplicationContext.getBean(PasswordUtil.class);
        String newPassword = util.encryptPassword(inPass, user.getUsername(), user.getSalt());

        return this.equals(newPassword, dbPass);
    }
}
