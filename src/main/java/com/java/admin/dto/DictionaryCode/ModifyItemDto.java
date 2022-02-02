package com.java.admin.dto.DictionaryCode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

@Data
@TableName("dictionary_code")
@ComponentScan
public class ModifyItemDto {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("字典编码")
    private String code;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序")
    private Integer sort;
}
