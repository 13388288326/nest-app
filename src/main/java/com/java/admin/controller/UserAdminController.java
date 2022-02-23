package com.java.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.entity.UserAdmin;
import com.java.admin.service.UserAdminService;
import com.java.admin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAdmins")
@Api(tags = "web端管理员")
public class UserAdminController {
    @Autowired
    private UserAdminService userAdminService;

    @PostMapping
    @ApiOperation("新增")
    public R addItem(@RequestBody UserAdmin userAdmin) {
        boolean isAdd = this.userAdminService.save(userAdmin);
        if (!isAdd) {
            throw new CustomException(ResponseEnum.INSERT_ERROR);
        }
        return R.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R deleteItem(@PathVariable String id) {
        this.userAdminService.removeById(id);
        return R.success();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R modifyItem(@PathVariable String id, @RequestBody UserAdmin userAdmin) {
        if (!id.equals(userAdmin.getId())) {
            throw new CustomException(ResponseEnum.PARAMS_IS_NULL);
        }
        this.userAdminService.updateById(userAdmin);
        return R.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R getItem(@PathVariable String id) {
        return ResultVoUtil.success(this.userAdminService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("列表")
    public R pageList(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String search) {
        JSONObject parse = JSONObject.parseObject(search);
        LambdaQueryWrapper<UserAdmin> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(parse.get("userName"))) {
            wrapper.eq(UserAdmin::getUserName, parse.get("userName"));
        }
        IPage<UserAdmin> resultPage = this.userAdminService.page(new Page<>(page, pageSize), wrapper);
        return ResultVoUtil.success(PageUtil.getPage(resultPage));
    }
}
