package com.java.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.entity.DictionaryValue;
import com.java.admin.mapper.DictionaryValueMapper;
import com.java.admin.service.DictionaryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryValueServiceImpl extends ServiceImpl<DictionaryValueMapper, DictionaryValue> implements DictionaryValueService {
    @Autowired
    private DictionaryValueMapper dictionaryValueMapper;

    @Override
    public List<DictionaryValue> getListByCode(String code) {
        LambdaQueryWrapper<DictionaryValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DictionaryValue::getCode, code);
        return this.dictionaryValueMapper.selectList(queryWrapper);
    }
}
