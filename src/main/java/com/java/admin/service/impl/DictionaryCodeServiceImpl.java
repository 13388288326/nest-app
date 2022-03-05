package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.entity.DictionaryCode;
import com.java.admin.mapper.DictionaryCodeMapper;
import com.java.admin.service.DictionaryCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DictionaryCodeServiceImpl extends ServiceImpl<DictionaryCodeMapper, DictionaryCode> implements DictionaryCodeService {

    @Autowired
    private DictionaryCodeMapper dictionaryCodeMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String transformStr(String dictName, int value) {
        return redisTemplate.opsForValue().get(dictName + "_" + value) != null ?
                redisTemplate.opsForValue().get(dictName + "_" + value).toString() : String.valueOf(value);
    }

    @Override
    public void refreshCache() {
        log.info("start 刷新码表缓存");
        List<DictionaryCode> list = dictionaryCodeMapper.selectList(null);
        long startTime = System.currentTimeMillis();
        list.forEach(item->{
            redisTemplate.opsForValue().set(item.getCode(),item.getDescription());
        });
        long endTime = System.currentTimeMillis();
        log.info("end 刷新码表缓存，总计：" + list.size() + "条，用时：" + (endTime - startTime) + "毫秒");
    }
}
