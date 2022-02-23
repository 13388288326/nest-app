package com.java.admin.controller;

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
