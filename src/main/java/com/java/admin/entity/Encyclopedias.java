package com.java.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 健康百科表(Encyclopedias)表实体类
 *
 * @author WangJun
 * @since 2022-02-04 20:49:13
 */

@Data
@ApiModel("健康百科表实体")
public class Encyclopedias {
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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}

