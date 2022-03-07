package com.java.admin.dto;

import io.swagger.annotations.ApiModelProperty;

public class RegisteredInsertDto {
    @ApiModelProperty("挂号主类型(数据字典):普通挂号:1｜核酸挂号:2")
    private String parentType;

    @ApiModelProperty("挂号费用、预约费用、检测费用")
    private String cost;

    @ApiModelProperty("套餐类型(数据字典)")
    private String bodyType;

    @ApiModelProperty("挂号子类型(数据字典)")
    private String childType;
}
