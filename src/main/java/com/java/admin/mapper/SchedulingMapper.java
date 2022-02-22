package com.java.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.admin.entity.Scheduling;
import org.apache.ibatis.annotations.Mapper;

/**
 * 排班表(Scheduling)表数据库访问层
 *
 * @author WangJun
 * @since 2022-02-22 14:23:10
 */
@Mapper
public interface SchedulingMapper extends BaseMapper<Scheduling> {

}

