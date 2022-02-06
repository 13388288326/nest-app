package com.java.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.admin.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生表(Doctor)表数据库访问层
 *
 * @author WangJun
 * @since 2022-02-06 14:01:52
 */
@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {

}

