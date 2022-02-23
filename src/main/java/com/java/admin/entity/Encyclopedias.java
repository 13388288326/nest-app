package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.java.admin.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 健康百科表(Encyclopedias)表实体类
 *
 * @author WangJun
 * @since 2022-02-04 20:49:13
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("健康百科表实体")
public class Encyclopedias extends BaseEntity {
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章图片")
    private String image;

    @ApiModelProperty("文章作者")
    private String author;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("文章状态")
    private String status;
}

