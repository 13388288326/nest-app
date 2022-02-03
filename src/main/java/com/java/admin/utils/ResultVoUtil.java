package com.java.admin.utils;

import com.java.admin.vo.ResultVo;

public class ResultVoUtil {
    public static ResultVo success(Object data){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(ResponseEnum.SUCCESS.getCode());
        resultVo.setMessage(ResponseEnum.SUCCESS.getMessage());
        resultVo.setData(data);
        return resultVo;
    }
}
