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
 * 挂号表(Registered)表实体类
 *
 * @author WangJun
 * @since 2022-02-22 12:14:43
 */

@Data
@ApiModel("挂号表实体")
public class Registered {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("挂号主类型(数据字典)")
    private String parentType;

    @ApiModelProperty("挂号费用、预约费用、检测费用")
    private String cost;

    @ApiModelProperty("套餐类型(数据字典)")
    private String bodyType;

    @ApiModelProperty("挂号子类型(数据字典)")
    private String childType;

    @ApiModelProperty("挂号状态")
    private String status;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}

