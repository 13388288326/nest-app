package com.java.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.entity.Registered;
import com.java.admin.service.RegisteredService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 挂号表(Registered)表控制层
 *
 * @author WangJun
 * @since 2022-02-22 12:14:44
 */
@RestController
@RequestMapping("/registered")
@Api(tags = "挂号表管理")
public class RegisteredController {
    @Autowired
    private RegisteredService registeredService;

    @PostMapping
    @ApiOperation("新增")
    public R insert(@RequestBody Registered registered) {
        this.registeredService.save(registered);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R delete(@PathVariable String id) {
        this.registeredService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R update(@RequestBody Registered registered) {
        this.registeredService.updateById(registered);
        return R.success();
    }


    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R selectOne(@PathVariable String id) {
        return ResultVoUtil.success(this.registeredService.getById(id));
    }

    @GetMapping
    @ApiOperation("列表")
    public R selectAll(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String search) {
        JSONObject parse = JSONObject.parseObject(search);
        LambdaQueryWrapper<Registered> wrapper = new LambdaQueryWrapper<>();

        IPage<Registered> resultPage = this.registeredService.page(new Page<>(page, pageSize), wrapper);
        return ResultVoUtil.success(PageUtil.getPage(resultPage));
    }
}

