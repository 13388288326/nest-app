package com.java.admin.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 统一返回枚举
 * */
@Getter
@ToString
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(200,"请求成功"),
    ERROR(500,"服务端错误"),
    BAD_SQL_GRAMMAR_ERROR(-101,"sql语法错误"),
    PARAMS_IS_NULL(500,"参数不能为空"),
    INSERT_ERROR(505,"数据库添加错误"),
    PRIMARY_KEY_IS_NOT_EQUAL(1001,"主键不一致");
    /**
     * 响应状态码
     * */
    private Integer code;
    /**
     * 响应信息
     * */
    private String message;
}