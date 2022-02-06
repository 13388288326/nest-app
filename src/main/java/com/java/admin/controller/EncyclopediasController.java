package com.java.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.entity.Encyclopedias;
import com.java.admin.service.EncyclopediasService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 健康百科表(Encyclopedias)表控制层
 *
 * @author WangJun
 * @since 2022-02-06 11:41:16
 */
@RestController
@RequestMapping("/encyclopedias")
@Api(tags = "健康百科表管理")
public class EncyclopediasController {
    @Autowired
    private EncyclopediasService encyclopediasService;

    @PostMapping
    @ApiOperation("新增")
    public R insert(@RequestBody Encyclopedias encyclopedias) {
        this.encyclopediasService.save(encyclopedias);
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R delete(@PathVariable String id) {
        this.encyclopediasService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R update(@RequestBody Encyclopedias encyclopedias) {
        this.encyclopediasService.updateById(encyclopedias);
        return R.success();
    }


    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R selectOne(@PathVariable String id) {
        return ResultVoUtil.success(this.encyclopediasService.getById(id));
    }

    @GetMapping
    @ApiOperation("列表")
    public R selectAll(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String search) {
        JSONObject parse = JSONObject.parseObject(search);
        LambdaQueryWrapper<Encyclopedias> wrapper = new LambdaQueryWrapper<>();

        IPage<Encyclopedias> resultPage = this.encyclopediasService.page(new Page<>(page, pageSize), wrapper);
        return ResultVoUtil.success(PageUtil.getPage(resultPage));
    }
}

