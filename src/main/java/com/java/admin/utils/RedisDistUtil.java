package com.java.admin.utils;

import com.java.admin.service.SysDictService;
import org.springframework.context.ApplicationContext;

public class RedisDistUtil {
    private static ApplicationContext context;
    /**
     * 转化码值
     * @return
     * @throws Exception
     */
    public static String transformStr(String field, String value)  {
        ApplicationContext context = SpringUtil.getApplicationContext();
        SysDictService sysDictService = context.getBean(SysDictService.class);
        return sysDictService.transformStr(field,value);
    }
}

