package com.java.admin.controller;

import com.java.admin.entity.User;
import com.java.admin.mapper.UserMapper;
import com.java.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "首页模块")
@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiOperation(value = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name")String name){
        List<User> users = this.userService.list(null);
        for (int i = 0; i < users.size(); i++) {//通过下标遍历数组
            System.out.println(users.get(i));
        }

        return ResponseEntity.ok("Hi:"+name);
    }
}