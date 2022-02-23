package com.java.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.dto.Patient.AddItemDto;
import com.java.admin.dto.Patient.ModifyItemDto;
import com.java.admin.entity.Patient;
import com.java.admin.service.PatientService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@Api(tags = "就诊人员管理")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    @ApiOperation("添加")
    public R addItem(@RequestBody Patient patient) {
        this.patientService.save(patient);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R deleteItem(@PathVariable String id) {
        this.patientService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R modifyItem(@PathVariable String id, @RequestBody Patient patient) {
        if (!id.equals(patient.getId())) {
            throw new CustomException(ResponseEnum.PARAMS_IS_NULL);
        }
        this.patientService.updateById(patient);
        return R.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R getItem(@PathVariable String id) {
        return ResultVoUtil.success(this.patientService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("列表")
    public R pageList(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String search) {
        JSONObject parse = JSONObject.parseObject(search);
        LambdaQueryWrapper<Patient> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(parse.get("userName"))) {
            wrapper.eq(Patient::getUserName, parse.get("userName"));
        }
        IPage<Patient> resultPage = this.patientService.page(new Page<>(page, pageSize), wrapper);
        return ResultVoUtil.success(PageUtil.getPage(resultPage));
    }

    @GetMapping("/listByUserId")
    @ApiOperation("根据用户id获取就诊人列表")
    public R patientList(@RequestParam String id) {
        LambdaQueryWrapper<Patient> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Patient::getUserPatientFkId, id);
        return ResultVoUtil.success(this.patientService.list(wrapper));
    }
}
