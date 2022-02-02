package com.java.admin.dto.DictionaryValue;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("dictionary_value")
public class AddItemDto {
    @ApiModelProperty(value = "父级字典编码Id",required = true)
    private Integer codeValueId;

    @ApiModelProperty(value = "字典值",required = true)
    private String value;

    @ApiModelProperty(value = "描述",required = true)
    private String description;

    @ApiModelProperty("排序")
    private Integer sort;
}
