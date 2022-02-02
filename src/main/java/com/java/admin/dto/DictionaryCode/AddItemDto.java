package com.java.admin.dto.DictionaryCode;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

@Data
@TableName("dictionary_code")
@ComponentScan
public class AddItemDto {
    @ApiModelProperty(value = "字典编码",required = true)
    private String code;

    @ApiModelProperty(value = "描述",required = true)
    private String description;

    @ApiModelProperty("排序")
    private Integer sort;
}
