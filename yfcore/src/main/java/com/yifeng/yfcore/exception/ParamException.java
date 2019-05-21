package com.yifeng.yfcore.exception;

/**
 * @Author: Kevin
 * @Description: 参数异常类<br>
 * @Date Created in 15:36 2019/4/1
 * @Modified By
 * @Version 1.0
 */
public class ParamException extends RuntimeException{

    private Integer code;

    public ParamException() {
        super();
    }

    public ParamException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    protected ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
