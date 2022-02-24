package com.java.admin.aspect;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.annotation.Dictionary;
import com.java.admin.entity.DictionaryValue;
import com.java.admin.utils.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class DictionaryAspect {
    @Autowired
    private RedisUtil redisUtil;

    @Pointcut("execution( * com.java.admin.mapper.*.*(..))")
    public void dictionary() {
    }

    @Around("dictionary()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        this.parseObject(result);
        return result;
    }

    private Object parseObject(Object o) {
        if (o instanceof Page || o instanceof List) {
//            List<?> resultList = new ArrayList<>();
//            List<?> list = o instanceof Page ? ((Page<?>) o).getRecords() : (List) o;
//            for (int i = 0; i < list.size(); i++) {
//                resultList.add(this.parseObjectText(list.get(i)));
//            }
//            return o instanceof Page ? ((Page<?>) o).setRecords(resultList) : resultList;
            return  null;
        } else {
            return this.parseObjectText(o);
        }
    }

    private Object parseObjectText(Object o) {
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        JSONObject json = (JSONObject) JSONObject.toJSON(o);
        for (Field field : fields) {
            if (field.getAnnotation(Dictionary.class) != null) {
                field.setAccessible(true);
                // 获取注解的value值
                String value = field.getAnnotation(Dictionary.class).value();
                // 获取添加了注解的字段名
                String fieldName = field.getName();
                // redis查询的key
                // 如果没传参数则将当前字段名作为redis的key
                String selectKey = StringUtils.isEmpty(value) ? fieldName : value;
                try {
                    // 获取字段的值
                    String oValue = (String) field.get(o);
                    List<DictionaryValue> list = (List<DictionaryValue>) this.redisUtil.get(selectKey);
                    for (int i = 0; i < list.size(); i++) {
                        String itemValue = list.get(i).getValue();
                        String description = list.get(i).getDescription();
                        if (oValue.equals(itemValue)) {
                            json.put(fieldName + "Str", description);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }
}
