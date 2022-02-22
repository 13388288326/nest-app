package com.java.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.entity.Scheduling;
import com.java.admin.service.SchedulingService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 排班表(Scheduling)表控制层
 *
 * @author WangJun
 * @since 2022-02-22 14:23:10
 */
@RestController
@RequestMapping("/scheduling")
@Api(tags = "排班表管理")
public class SchedulingController {
    @Autowired
    private SchedulingService schedulingService;

    @PostMapping
    @ApiOperation("新增")
    public R insert(@RequestBody Scheduling scheduling) {
        this.schedulingService.save(scheduling);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R delete(@PathVariable String id) {
        this.schedulingService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R update(@RequestBody Scheduling scheduling) {
        this.schedulingService.updateById(scheduling);
        return R.success();
    }


    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R selectOne(@PathVariable String id) {
        return ResultVoUtil.success(this.schedulingService.getById(id));
    }

    @GetMapping
    @ApiOperation("列表")
    public R selectAll(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String search) {
        JSONObject parse = JSONObject.parseObject(search);
        LambdaQueryWrapper<Scheduling> wrapper = new LambdaQueryWrapper<>();

        IPage<Scheduling> resultPage = this.schedulingService.page(new Page<>(page, pageSize), wrapper);
        return ResultVoUtil.success(PageUtil.getPage(resultPage));
    }
}

