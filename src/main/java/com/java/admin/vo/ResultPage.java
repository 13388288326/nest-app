package com.java.admin.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResultPage<T> {
    private List<T> list;
    private Integer total;
}
