package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.mapper.DepartmentMapper;
import com.java.admin.entity.Department;
import com.java.admin.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * 科室表(Department)表服务实现类
 *
 * @author WangJun
 * @since 2022-02-06 13:52:05
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}

