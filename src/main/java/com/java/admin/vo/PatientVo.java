package com.java.admin.vo;

import com.java.admin.entity.Patient;
import com.java.admin.utils.RedisDistUtil;
import java.io.Serializable;

public class PatientVo extends Patient implements Serializable{
    private static final long serialVersionUID = -2145503717390503506L;

    private String CertificateTypeStr;

    private String getCertificateTypeStr() {
        return RedisDistUtil.transformStr("certificateType",this.getCertificateType());
    }
}
