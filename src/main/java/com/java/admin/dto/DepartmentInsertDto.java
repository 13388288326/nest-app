package com.java.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("新增科室")
@Data
public class DepartmentInsertDto {
    @ApiModelProperty(value = "科室名称",required = true)
    private String departmentName;

    @ApiModelProperty(value = "所属院区(数据字典)",required = true)
    private String campus;

    @ApiModelProperty("父级科室id,根级别不传")
    private String parentId;

    @ApiModelProperty("科室位置")
    private String location;

    @ApiModelProperty("科室状态 0:关闭 1:开启,不传默认为0")
    private String status;
}
