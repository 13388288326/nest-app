package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.mapper.DoctorMapper;
import com.java.admin.entity.Doctor;
import com.java.admin.service.DoctorService;
import org.springframework.stereotype.Service;

/**
 * 医生表(Doctor)表服务实现类
 *
 * @author WangJun
 * @since 2022-02-06 14:01:53
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

}

