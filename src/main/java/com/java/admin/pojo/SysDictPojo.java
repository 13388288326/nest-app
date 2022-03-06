package com.java.admin.pojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class SysDictPojo implements Serializable {
    private static final long serialVersionUID = 7845051152365224116L;

    private String code;
    private String description;
    private String value;
}
