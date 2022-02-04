package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.entity.Patient;
import com.java.admin.mapper.PatientMapper;
import com.java.admin.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {
}
