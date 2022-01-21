package com.java.admin.controller;

import com.java.admin.entity.User;
import com.java.admin.mapper.UserMapper;
import com.java.admin.service.UserService;
import com.java.admin.utils.Assert;
import com.java.admin.utils.CustomException;
import com.java.admin.utils.JWTUtils;
import com.java.admin.utils.ResponseEnum;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "首页模块")
@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtils jwtUtils;

    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiOperation(value = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name")String name){
        Map<String,Object> claims = new HashMap<>();
        claims.put("wj",2333);
        Object a = null;
        Assert.notNull(a, ResponseEnum.PARAMS_IS_NULL);

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ3aiI6MjMzMywiZXhwIjoxNjQyODExMDk2fQ.xrIDIFfeJwwLK9o0wHphKicRiKsRzA13KBKukwGH1SQ";

        Map<String,Object> claims1 = jwtUtils.parseToken(token);
        for (Map.Entry<String, Object> entry : claims1.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
//        System.out.println("name = " + jwtUtils.generateToken(claims));
//        List<User> users = this.userService.list(null);
//        for (int i = 0; i < users.size(); i++) {//通过下标遍历数组
////            System.out.println(users.get(i));
//        }

        return ResponseEntity.ok("Hi:"+name);
    }
}