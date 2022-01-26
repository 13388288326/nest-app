package com.java.admin.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("添加用户实体")
@TableName("user")
public class UserAddDto {
    @ApiModelProperty("微信openId")
    private String openId;

    @ApiModelProperty("昵称")
    private String nickName;
}
