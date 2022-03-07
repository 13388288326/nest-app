package com.java.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.dto.DepartmentInsertDto;
import com.java.admin.mapper.DepartmentMapper;
import com.java.admin.entity.Department;
import com.java.admin.service.DepartmentService;
import com.java.admin.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 科室表(Department)表服务实现类
 *
 * @author WangJun
 * @since 2022-02-06 13:52:05
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Boolean addData(DepartmentInsertDto department) {

        Department insertDept = new Department();
        insertDept.setDepartmentName(department.getDepartmentName());
        //可以不传默认传入root
        if (StringUtils.isBlank(department.getParentId())) {
            insertDept.setParentId("root");
        }
        insertDept.setCampus(department.getCampus());
        insertDept.setLocation(department.getLocation());
        insertDept.setStatus(StringUtils.isBlank(department.getStatus()) ? "0" : "1");
        return  this.departmentService.save(insertDept);
    }
}

