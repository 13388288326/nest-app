package com.java.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.dto.DepartmentInsertDto;
import com.java.admin.entity.Department;
import com.java.admin.service.DepartmentService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科室表(Department)表控制层
 *
 * @author WangJun
 * @since 2022-02-06 13:52:05
 */
@RestController
@RequestMapping("/department")
@Api(tags = "科室表管理")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    @ApiOperation("新增")
    public R insert(@RequestBody DepartmentInsertDto department) {
        this.departmentService.addData(department);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R delete(@PathVariable String id) {
        this.departmentService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R update(@RequestBody Department department) {
        this.departmentService.updateById(department);
        return R.success();
    }


    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R selectOne(@PathVariable String id) {
        return ResultVoUtil.success(this.departmentService.getById(id));
    }

    @GetMapping
    @ApiOperation("列表")
    public R selectAll(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String search) {
        JSONObject parse = JSONObject.parseObject(search);
        LambdaQueryWrapper<Department> wrapper = new LambdaQueryWrapper<>();

        IPage<Department> resultPage = this.departmentService.page(new Page<>(page, pageSize), wrapper);
        return ResultVoUtil.success(PageUtil.getPage(resultPage));
    }
}

