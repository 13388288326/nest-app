package com.java.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.admin.entity.DictionaryCode;

public interface DictionaryCodeService extends IService<DictionaryCode> {
    String transformStr(String dictName, int value);

    void refreshCache();
}
