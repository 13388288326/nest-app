package com.java.admin.dto.Patient;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddItemDto {
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

    @ApiModelProperty("证件类型(数据字典)")
    private String certificateType;

    @ApiModelProperty(value = "证件号码",required = true)
    private String certificateNumber;

    @ApiModelProperty("关系(数据字典)")
    private String relationship;

    @ApiModelProperty(value = "用户id",required = true)
    private String userId;
}
