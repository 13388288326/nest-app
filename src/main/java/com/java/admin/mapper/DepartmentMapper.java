package com.java.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.admin.entity.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * 科室表(Department)表数据库访问层
 *
 * @author WangJun
 * @since 2022-02-06 13:52:05
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

}

