package com.java.admin.vo;

import com.java.admin.common.BaseEntity;
import com.java.admin.entity.Patient;
import com.java.admin.utils.RedisDistUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class PatientVo extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -2145503717390503506L;

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

    @ApiModelProperty(value = "证件类型(数据字典)",required = true)
    private String certificateType;

    @ApiModelProperty(value = "证件号码",required = true)
    private String certificateNumber;

    @ApiModelProperty(value = "关系(数据字典)",required = true)
    private String relationship;

    @ApiModelProperty("证件类型")
    private String CertificateTypeStr;

    public String getCertificateTypeStr() {
        return RedisDistUtil.transformStr("certificateType",this.getCertificateType());
    }
}
