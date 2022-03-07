package com.java.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.admin.dto.DepartmentInsertDto;
import com.java.admin.entity.Department;

/**
 * 科室表(Department)表服务接口
 *
 * @author WangJun
 * @since 2022-02-06 13:52:05
 */
public interface DepartmentService extends IService<Department> {
    Boolean addData(DepartmentInsertDto department);
}

