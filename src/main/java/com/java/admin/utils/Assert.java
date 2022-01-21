package com.java.admin.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class Assert {
    /**
     * 断言不为null
     * 为null抛出异常
     * */
    public static void notNull(Object o,ResponseEnum responseEnum){
        if(o==null){
            log.info("<Assert>断言->参数为null");
            throw new CustomException(responseEnum);
        }
    }

    /**
     * 断言为null
     * 不为null抛出异常
     * */
    public static void isNull(Object o,ResponseEnum responseEnum){
        if(o!=null){
            log.info("<Assert>断言->参数不为null");
            throw new CustomException(responseEnum);
        }
    }

    /**
     * 断言为true
     * 不为true抛出异常
     * */
    public static void isTrue(boolean expression,ResponseEnum responseEnum){
        if(!expression){
            log.info("<Assert>断言->参数不为True");
            throw new CustomException(responseEnum);
        }
    }

    /**
     * 断言两个参数不相等
     * 相等抛出异常
     * */
    public static void notEquals(Object o1,Object o2,ResponseEnum responseEnum){
        if(o1.equals(o2)){
            log.info("<Assert>断言->参数不相等");
            throw new CustomException(responseEnum);
        }
    }

    /**
     * 断言两个参数相等
     * 不相等抛出异常
     * */
    public static void equals(Object o1,Object o2,ResponseEnum responseEnum){
        if(!o1.equals(o2)){
            log.info("<Assert>断言->参数不相等");
            throw new CustomException(responseEnum);
        }
    }

    /**
     * 断言不为空字符串
     * 空字符串抛出异常
     * */
    public static void notEmpty(String s,ResponseEnum responseEnum){
        if(StringUtils.isEmpty(s)){
            log.info("<Assert>断言->参数为空字符串");
            throw new CustomException(responseEnum);
        }
    }
}
