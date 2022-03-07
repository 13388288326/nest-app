package com.java.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.admin.entity.Patient;
import com.java.admin.vo.PatientVo;

public interface PatientService extends IService<Patient> {
    PatientVo getDetail(String id);
}
