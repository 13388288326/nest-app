package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.admin.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 排班表(Scheduling)表实体类
 *
 * @author WangJun
 * @since 2022-02-22 14:23:10
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("排班表实体")
public class Scheduling extends BaseEntity {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("排班日期(YYYY-MM-DD)")
    private Date time;

    @ApiModelProperty("上午总数量")
    private Integer morningTotalNumber;

    @ApiModelProperty("上午数量")
    private Integer morningNumber;

    @ApiModelProperty("上午接诊时间(HH:mm:ss)")
    private LocalTime morningTime;

    @ApiModelProperty("下午总数量")
    private Integer afternoonTotalNumber;

    @ApiModelProperty("下午数量")
    private Integer afternoonNumber;

    @ApiModelProperty("下午接诊时间(HH:mm:ss)")
    private LocalTime afternoonTime;

}

