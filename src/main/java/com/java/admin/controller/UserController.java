package com.java.admin.controller;

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
    public R addItem(@RequestBody User user) {
        boolean b = this.userService.save(user);
        Assert.isTrue(b, ResponseEnum.INSERT_ERROR);
        return R.success();
    }
}
