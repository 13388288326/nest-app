package com.java.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.admin.entity.UserAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAdminMapper extends BaseMapper<UserAdmin> {
}
