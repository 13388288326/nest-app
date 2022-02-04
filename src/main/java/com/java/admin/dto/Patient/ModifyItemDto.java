package com.java.admin.dto.Patient;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("patient")
public class ModifyItemDto extends AddItemDto{
    @ApiModelProperty("主键")
    private String id;
}
