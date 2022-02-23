package com.java.admin.vo;

import com.java.admin.entity.Patient;
import com.java.admin.utils.Helper;
import com.java.admin.utils.RedisUtil;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

@EqualsAndHashCode(callSuper = true)
public class PatientVo extends Patient {
    @Autowired
    private RedisUtil redisUtils;

    private String certificateTypeStr;
    private String relationshipStr;

    public String getCertificateTypeStr() {
        Object o = redisUtils.get("certificateType");
        String  fieldValue =(String) Helper.getFieldValueByName(this.getCertificateType(), o);
        System.out.println(fieldValue);
        return "";
    }

    public String getRelationshipStr() {
        return relationshipStr;
    }
}
