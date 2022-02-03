package com.java.admin.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java.admin.vo.ResultPage;

public class PageUtil {
    public static ResultPage getPage(IPage page){
        ResultPage<Object> resultPage = new ResultPage<>();
        resultPage.setList(page.getRecords());
        resultPage.setTotal(Math.toIntExact(page.getTotal()));
        return resultPage;
    }
}
