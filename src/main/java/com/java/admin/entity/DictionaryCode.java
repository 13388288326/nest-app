package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.java.admin.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("字典编码")
public class DictionaryCode extends BaseEntity {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty("字典编码")
    private String code;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序")
    private String sort;
}
