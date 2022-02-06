package com.java.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.entity.Doctor;
import com.java.admin.service.DoctorService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医生表(Doctor)表控制层
 *
 * @author WangJun
 * @since 2022-02-06 14:01:53
 */
@RestController
@RequestMapping("/doctor")
@Api(tags = "医生表管理")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @ApiOperation("新增")
    public R insert(@RequestBody Doctor doctor) {
        this.doctorService.save(doctor);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R delete(@PathVariable String id) {
        this.doctorService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R update(@RequestBody Doctor doctor) {
        this.doctorService.updateById(doctor);
        return R.success();
    }


    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R selectOne(@PathVariable String id) {
        return ResultVoUtil.success(this.doctorService.getById(id));
    }

    @GetMapping
    @ApiOperation("列表")
    public R selectAll(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String search) {
        JSONObject parse = JSONObject.parseObject(search);
        LambdaQueryWrapper<Doctor> wrapper = new LambdaQueryWrapper<>();

        IPage<Doctor> resultPage = this.doctorService.page(new Page<>(page, pageSize), wrapper);
        return ResultVoUtil.success(PageUtil.getPage(resultPage));
    }
}

