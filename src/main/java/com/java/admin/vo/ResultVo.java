package com.java.admin.vo;

import com.java.admin.utils.R;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 返回类
 * */
@EqualsAndHashCode(callSuper = true)
@Data
public class ResultVo<T> extends R {
    private T data;
}
