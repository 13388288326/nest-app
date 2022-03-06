package com.java.admin.test;

import com.java.admin.service.SysDictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysDictPojoTest {
    @Autowired
    SysDictService sysDictService;
    @Test
    void sx(){
        sysDictService.refreshCache();
    }
}
