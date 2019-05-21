package com.yifeng.yfcore.common;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 16:21 2019/3/28
 * @Modified By
 * @Version 1.0
 */
public enum ReturnCode {
    SUCCESS(200),
    FAILURE(100),
    PARAM(400),
    PERMISSION(403);
    //防止字段值被修改，增加的字段也统一final表示常量
    private final Integer code;

    private ReturnCode(Integer code){
        this.code = code;

    }
    public Integer getCode() {
        return code;
    }
}
