package com.java.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.admin.entity.DictionaryValue;

import java.util.List;

public interface DictionaryValueService extends IService<DictionaryValue> {
    /**
     * 通过code获取列表
     * */
    List<DictionaryValue> getListByCode(String code);
    /**
     * 批量更新数据的code
     * */
    Boolean updateByCode(String id, String code);
}
