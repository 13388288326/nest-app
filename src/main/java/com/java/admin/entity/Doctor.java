package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.java.admin.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生表(Doctor)表实体类
 *
 * @author WangJun
 * @since 2022-02-06 14:01:52
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("医生表实体")
public class Doctor extends BaseEntity {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("医生名称")
    private String name;

    @ApiModelProperty("医生图片")
    private String image;

    @ApiModelProperty("医生职称(数据字典)")
    private String title;

    @ApiModelProperty("医生标签(数据字典)")
    private String tag;

    @ApiModelProperty("医生介绍")
    private String introduce;

    @ApiModelProperty("挂号费")
    private Integer registrationFee;

    @ApiModelProperty("科室-医生外键")
    private Integer departmentDoctorFkId;
}

