package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.mapper.SchedulingMapper;
import com.java.admin.entity.Scheduling;
import com.java.admin.service.SchedulingService;
import org.springframework.stereotype.Service;

/**
 * 排班表(Scheduling)表服务实现类
 *
 * @author WangJun
 * @since 2022-02-22 14:23:10
 */
@Service
public class SchedulingServiceImpl extends ServiceImpl<SchedulingMapper, Scheduling> implements SchedulingService {

}

