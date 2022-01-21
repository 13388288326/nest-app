package com.java.admin.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomException extends RuntimeException{
    /**
     * 状态码
     * */
    private Integer code;

    /**
     * 描述信息
     * */
    private String message;

    /**
     * @param message 错误信息
     * */
    public CustomException(String message){
        this.message = message;
    }

    /**
     * @param message 错误信息
     * @param code 状态码
     * */
    public CustomException(String message,Integer code){
        this.message = message;
        this.code = code;
    }

    /**
     * @param message 错误信息
     * @param code 状态码
     * @param cause 原始异常对象
     * */
    public CustomException(String message,Integer code,Throwable cause){
        super(cause);
        this.message = message;
        this.code = code;
    }

    /**
     * @param responseEnum 枚举类创建异常
     * */
    public CustomException(ResponseEnum responseEnum){
        this.message = responseEnum.getMessage();
        this.code = responseEnum.getCode();
    }

    /**
     * @param responseEnum 枚举类创建异常
     * @param cause 原始异常对象
     * */
    public CustomException(ResponseEnum responseEnum,Throwable cause){
        super(cause);
        this.message = responseEnum.getMessage();
        this.code = responseEnum.getCode();
    }
}
