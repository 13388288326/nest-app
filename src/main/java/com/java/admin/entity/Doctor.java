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

/**
 * 医生表(Doctor)表实体类
 *
 * @author WangJun
 * @since 2022-02-06 14:01:52
 */

@Data
@ApiModel("医生表实体")
public class Doctor {
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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}

