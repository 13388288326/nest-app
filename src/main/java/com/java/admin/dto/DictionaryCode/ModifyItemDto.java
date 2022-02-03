package com.java.admin.dto.DictionaryCode;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("dictionary_code")
public class ModifyItemDto {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("字典编码")
    private String code;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序")
    private Integer sort;
}
