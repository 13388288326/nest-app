package com.java.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.admin.pojo.SysDictPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDictMapper extends BaseMapper<SysDictPojo> {
    List<SysDictPojo> selectDictAll();
}
