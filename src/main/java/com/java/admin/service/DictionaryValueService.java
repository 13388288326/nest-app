package com.java.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.admin.entity.DictionaryValue;

import java.util.List;

public interface DictionaryValueService extends IService<DictionaryValue> {
    List<DictionaryValue> getListByCode(String code);
}
