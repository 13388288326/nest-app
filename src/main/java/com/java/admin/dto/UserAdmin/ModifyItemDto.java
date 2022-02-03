package com.java.admin.dto.UserAdmin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("user_admin")
public class ModifyItemDto {
    @ApiModelProperty(value = "主键",required = true)
    private String id;

    @ApiModelProperty(value = "用户名",required = true)
    private String userName;

    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @ApiModelProperty(value = "电话号码",required = true)
    private String phoneNumber;

    @ApiModelProperty("登陆账号")
    private String account;

    @ApiModelProperty("是否启用 0:未启用,1:启用")
    private String enable;
}
