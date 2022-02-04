package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("就诊人表")
public class Patient {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty("就诊人姓名")
    private String userName;

    @ApiModelProperty("就诊卡号")
    private String cardNumber;

    @ApiModelProperty("就诊人电话号码")
    private String phoneNumber;

    @ApiModelProperty("就诊人地址")
    private String address;

    @ApiModelProperty("默认就诊人 0:不是,1:是")
    private String defaultSelect;

    @ApiModelProperty("证件类型(数据字典)")
    private String certificateType;

    @ApiModelProperty("证件号码")
    private String certificateNumber;

    @ApiModelProperty("关系(数据字典)")
    private String relationship;

    @ApiModelProperty("用户-就诊人外键id")
    private String userPatientFkId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;
}
