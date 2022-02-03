package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.entity.UserAdmin;
import com.java.admin.mapper.UserAdminMapper;
import com.java.admin.service.UserAdminService;
import org.springframework.stereotype.Service;

@Service
public class UserAdminServiceImpl extends ServiceImpl<UserAdminMapper, UserAdmin> implements UserAdminService {
}
