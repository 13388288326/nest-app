package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.mapper.RegisteredMapper;
import com.java.admin.entity.Registered;
import com.java.admin.service.RegisteredService;
import org.springframework.stereotype.Service;

/**
 * 挂号表(Registered)表服务实现类
 *
 * @author WangJun
 * @since 2022-02-22 12:14:44
 */
@Service
public class RegisteredServiceImpl extends ServiceImpl<RegisteredMapper, Registered> implements RegisteredService {

}

