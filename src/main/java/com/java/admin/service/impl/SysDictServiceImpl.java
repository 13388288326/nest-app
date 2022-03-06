package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.mapper.SysDictMapper;
import com.java.admin.pojo.SysDictPojo;
import com.java.admin.service.SysDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictPojo> implements SysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String transformStr(String dictName, String value) {
        return (String) redisTemplate.opsForValue().get(dictName+"_"+value);
    }

    @Override
    public void refreshCache() {
        log.info("开始刷新数据字典缓存");
        List<SysDictPojo> list = sysDictMapper.selectDictAll();
        long startTime = System.currentTimeMillis();
        for (SysDictPojo sysDictPojo : list) {
            redisTemplate.opsForValue().set(sysDictPojo.getCode()+"_"+sysDictPojo.getValue(),sysDictPojo.getDescription());
        }
        long endTime = System.currentTimeMillis();
        log.info("刷新数据字典缓存结束，总计：" + list.size() + "条，用时：" + (endTime - startTime) + "毫秒");
    }
}
