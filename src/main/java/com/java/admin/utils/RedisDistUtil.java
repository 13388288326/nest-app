package com.java.admin.utils;

import com.java.admin.service.DictionaryCodeService;
import org.springframework.context.ApplicationContext;

public class RedisDistUtil {
    private static ApplicationContext context;
    /**
     * 转化码值
     * @param distname
     * @param value
     * @return
     * @throws Exception
     */
    public static String transformStr(String distname, int value)  {
        ApplicationContext context = SpringUtil.getApplicationContext();
        DictionaryCodeService dictionaryCodeService = context.getBean(DictionaryCodeService.class);
        return dictionaryCodeService.transformStr(distname,value);
    }
}

