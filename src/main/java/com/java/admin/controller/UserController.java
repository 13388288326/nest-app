package com.java.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.admin.dto.UserAddDto;
import com.java.admin.entity.User;
import com.java.admin.service.UserService;
import com.java.admin.utils.Assert;
import com.java.admin.utils.R;
import com.java.admin.utils.ResponseEnum;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/user/{page}/{pageSize}")
//    @ApiOperation("获取管理员列表")
//    public R pageList(
//            @PathVariable @ApiParam(name = "page", value = "页码", required = true) String page,
//            @PathVariable @ApiParam(name = "pageSize", value = "页面条数", required = true) String pageSize,
//            @RequestBody String o
////            @PathVariable @ApiParam(name = "search", value = "搜索条件", required = false) String search
//    ) {
//        System.out.println(o);
//        IPage<User> query = this.userService.page(new Page<>(Integer.parseInt(page), Integer.parseInt(pageSize)), null);
//
//        return R.ok().data("list", query.getRecords()).data("total", query.getTotal());
//
//    }

    @PostMapping
    @ApiOperation("添加用户")
    public R addItem(@RequestBody UserAddDto user) {
        User insertUser = new User();
        insertUser.setNickName(user.getNickName());
        insertUser.setOpenId(user.getOpenId());
        boolean b = this.userService.save(insertUser);
        Assert.isTrue(b, ResponseEnum.INSERT_ERROR);
        return R.success();
    }
}
