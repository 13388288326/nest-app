package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.java.admin.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("就诊人表")
public class Patient extends BaseEntity {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "就诊人姓名",required = true)
    private String userName;

    @ApiModelProperty(value = "就诊卡号",required = true)
    private String cardNumber;

    @ApiModelProperty(value = "就诊人电话号码",required = true)
    private String phoneNumber;

    @ApiModelProperty("就诊人地址")
    private String address;

    @ApiModelProperty("默认就诊人 0:不是,1:是")
    private String defaultSelect;

    @ApiModelProperty(value = "证件类型(数据字典)",required = true)
    private String certificateType;

    @ApiModelProperty(value = "证件号码",required = true)
    private String certificateNumber;

    @ApiModelProperty(value = "关系(数据字典)",required = true)
    private String relationship;

    @ApiModelProperty("用户-就诊人外键id")
    private String userPatientFkId;
}
