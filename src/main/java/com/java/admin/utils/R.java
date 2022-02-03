package com.java.admin.utils;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回类
 * */
@Data
public class R  {
    /**
     * 描述信息
     * */
    private String message;
    /**
     * http状态码
     * */
    private Integer code;
//    private Integer code;
//    private String message;
//    private Map<String,Object> data = new HashMap<>();
//
//    /**
//     * 构造函数私有化
//     */
//    private R(){}

//    /**
//     * 返回成功结果
//     * @return R
//     */
//    public static R ok(){
//        R r = new R();
//        r.setCode(ResponseEnum.SUCCESS.getCode());
//        r.setMessage(ResponseEnum.SUCCESS.getMessage());
//        return r;
//    }
//
    /**
     * 返回成功结果
     * @return R
     */
    public static R success(){
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }
    /**
     * 返回失败结果
     * @return R
     */
    public static R error(){
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    /**
     * 返回失败结果
     * @return R
     */
    public static R error(String message,Integer code){
        R r = new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    /**
     * 返回失败结果
     * @return R
     */
    public static R error(String message){
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(message);
        return r;
    }

    /**
     * 设置特定返回结果
     * @return R
     */
    public static R setResult(ResponseEnum responseEnum){
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }
}
