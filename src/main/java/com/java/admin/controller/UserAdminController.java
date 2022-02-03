package com.java.admin.controller;

import com.java.admin.dto.UserAdmin.ModifyItemDto;
import com.java.admin.dto.UserAdmin.AddItemDto;
import com.java.admin.entity.UserAdmin;
import com.java.admin.service.UserAdminService;
import com.java.admin.utils.CustomException;
import com.java.admin.utils.R;
import com.java.admin.utils.ResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAdmins")
@Api(tags = "管理员")
public class UserAdminController {
    @Autowired
    private UserAdminService userAdminService;

    @PostMapping
    @ApiOperation("新增")
    public R addItem(@RequestBody AddItemDto addItemDto) {
        UserAdmin admin = new UserAdmin();
        admin.setUserName(addItemDto.getUserName());
        admin.setPassword(addItemDto.getPassword());
        admin.setPhoneNumber(addItemDto.getPhoneNumber());
        admin.setAccount(addItemDto.getAccount());
        admin.setEnable(addItemDto.getEnable());
        boolean isAdd = this.userAdminService.save(admin);
        if (!isAdd) {
            throw new CustomException(ResponseEnum.INSERT_ERROR);
        }
        return R.ok();
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public R deleteItem(@PathVariable String id){
        this.userAdminService.removeById(id);
        return R.ok();
    }

    @PutMapping("/{id}")
    @ApiOperation("修改")
    public R modifyItem(@PathVariable String id,@RequestBody ModifyItemDto putObject){
        if(!new Integer(id).equals(putObject.getId())){
            throw new CustomException(ResponseEnum.PARAMS_IS_NULL);
        }
        UserAdmin admin = new UserAdmin();
        admin.setUserName(putObject.getUserName());
        admin.setPassword(putObject.getPassword());
        admin.setPhoneNumber(putObject.getPhoneNumber());
        admin.setAccount(putObject.getAccount());
        admin.setEnable(putObject.getEnable());
        admin.setId(putObject.getId());
        this.userAdminService.updateById(admin);
        return R.ok();
    }

    @GetMapping("/{id}")
    @ApiOperation("详情")
    public R getItem(@PathVariable String id){
        UserAdmin item = this.userAdminService.getById(id);
        return R.ok().data("details",item);
    }
}
