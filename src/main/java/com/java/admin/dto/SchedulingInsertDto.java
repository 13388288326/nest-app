package com.java.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel("新增排班")
@Data
public class SchedulingInsertDto {
    @ApiModelProperty("医生Id")
    private String DoctorId;

    @ApiModelProperty("科室父级id")
    private String DepartmentParentId;

    @ApiModelProperty("科室id")
    private String DepartmentId;

    @ApiModelProperty("排班日期(YYYY-MM-DD)")
    private LocalDateTime time;

    @ApiModelProperty("上午总数量")
    private Integer morningTotalNumber;

    @ApiModelProperty("上午数量")
    private Integer morningNumber;

    @ApiModelProperty("上午接诊时间(HH:mm:ss)")
    private LocalDateTime morningTime;

    @ApiModelProperty("下午总数量")
    private Integer afternoonTotalNumber;

    @ApiModelProperty("下午数量")
    private Integer afternoonNumber;

    @ApiModelProperty("下午接诊时间(HH:mm:ss)")
    private LocalDateTime afternoonTime;
}
