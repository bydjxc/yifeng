package com.yifeng.yfcore.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: Kevin
 * @Description:
 * 密码加密方式采用  SHA+盐+密码的方式
 * <br>
 * @Date Created in 16:09 2019/3/26
 * @Modified By
 * @Version 1.0
 */
@Component
public class PasswordUtil {

    @Value("${password.algorithmName}")
    private String algorithmName;
    @Value("${password.hashIterations}")
    private Integer hashIterations;

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    public String[] encryptPassword(String password, String username) {

        String salt = randomNumberGenerator.nextBytes().toHex();

        String newPassword = new SimpleHash(
                algorithmName,           //加密算法
                password,      //密码
                ByteSource.Util.bytes(username+salt),  //salt盐   username + salt
                hashIterations   //迭代次数
        ).toHex();
        return new String[]{newPassword, salt};
    }
    public String encryptPassword(String password, String username, String salt) {

        return new SimpleHash(
                algorithmName,           //加密算法
                password,      //密码
                ByteSource.Util.bytes(username+salt),  //salt盐   username + salt
                hashIterations   //迭代次数
        ).toHex();
    }

    public static void main(String[] args) {
        PasswordUtil passwordUtil = new PasswordUtil();
        String[] pass = passwordUtil.encryptPassword("123", "kevin");
        System.out.println(pass[0]+"\n"+pass[1]);

    }
}
