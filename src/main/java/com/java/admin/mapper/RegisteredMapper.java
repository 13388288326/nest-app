package com.java.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.admin.entity.Registered;
import org.apache.ibatis.annotations.Mapper;

/**
 * 挂号表(Registered)表数据库访问层
 *
 * @author WangJun
 * @since 2022-02-22 12:14:43
 */
@Mapper
public interface RegisteredMapper extends BaseMapper<Registered> {

}

