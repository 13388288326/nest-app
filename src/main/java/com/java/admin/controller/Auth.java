package com.java.admin.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.admin.entity.User;
import com.java.admin.entity.UserAdmin;
import com.java.admin.service.UserAdminService;
import com.java.admin.service.UserService;
import com.java.admin.utils.CustomException;
import com.java.admin.utils.R;
import com.java.admin.utils.ResultVoUtil;
import com.java.admin.utils.WxUtils;
import com.java.admin.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "身份验证")
@RequestMapping("/auth")
public class Auth {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAdminService userAdminService;

    @GetMapping("/getOpenId")
    @ApiOperation("获取openId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "微信code", required = true),
            @ApiImplicitParam(name = "nickName", value = "微信昵称", required = true)
    })
    public R getOpenId(String code, String nickName) {
        Map<String, Object> wxResult = WxUtils.getOpenIdByCode(code);
        String openId = (String) wxResult.get("openid");
        User user = new User();
        user.setOpenId(openId);
        user.setNickName(nickName);
        this.userService.save(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("openId", openId);
        return ResultVoUtil.success(map);
    }

    @PostMapping("/getToken")
    @ApiOperation("通过用户名密码获取token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public R getToken(String userName, String password) {
        LambdaQueryWrapper<UserAdmin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAdmin::getUserName, userName).eq(UserAdmin::getPassword, password);
        UserAdmin userAdmin = this.userAdminService.getOne(queryWrapper);
        if (userAdmin == null) {
            throw new CustomException("用户名或密码错误");
        }

        Map<String, Object> map = new HashMap<>();

        return R.success();
    }

    @PostMapping("/getTokenByOpenId")
    @ApiOperation("通过openId获取token")
    public R getTokenByOpenId(@RequestParam(name = "openId") String openId) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getOpenId, openId);
        User user = this.userService.getOne(queryWrapper);
        // 生成token
        if (user == null) {
            throw new CustomException("openId错误");
        }
        HashMap<String, Object> map = new HashMap<>();

        return ResultVoUtil.success(user);
    }
}
