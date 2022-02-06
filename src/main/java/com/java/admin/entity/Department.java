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
 * 科室表(Department)表实体类
 *
 * @author WangJun
 * @since 2022-02-06 13:52:05
 */

@Data
@ApiModel("科室表实体")
public class Department {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("科室名称")
    private String departmentName;

    @ApiModelProperty("科室类型(数据字典)")
    private String departmentType;

    @ApiModelProperty("数据字典")
    private String campus;

    @ApiModelProperty("科室位置")
    private String location;

    @ApiModelProperty("科室状态 0:关闭 1:开启")
    private String status;

    @ApiModelProperty("父级科室id,根级别0")
    private Integer parentId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}

