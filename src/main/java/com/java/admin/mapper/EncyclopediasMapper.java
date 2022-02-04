package com.java.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.admin.entity.Encyclopedias;
import org.apache.ibatis.annotations.Mapper;

/**
 * 健康百科表(Encyclopedias)表数据库访问层
 *
 * @author WangJun
 * @since 2022-02-04 21:01:08
 */
@Mapper
public interface EncyclopediasMapper extends BaseMapper<Encyclopedias> {

}

