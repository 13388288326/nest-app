package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.java.admin.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("用户表实体")
public class User extends BaseEntity {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty("微信openId")
    private String openId;

    @ApiModelProperty("昵称")
    private String nickName;
}
