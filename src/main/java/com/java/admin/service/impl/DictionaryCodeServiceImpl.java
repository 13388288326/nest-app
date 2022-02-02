package com.java.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.admin.entity.DictionaryCode;
import com.java.admin.mapper.DictionaryCodeMapper;
import com.java.admin.service.DictionaryCodeService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryCodeServiceImpl extends ServiceImpl<DictionaryCodeMapper, DictionaryCode> implements DictionaryCodeService {
}
