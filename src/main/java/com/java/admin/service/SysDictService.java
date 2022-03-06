package com.java.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.admin.pojo.SysDictPojo;

public interface SysDictService extends IService<SysDictPojo> {
    String transformStr(String dictName, String value);
    void refreshCache();
}
