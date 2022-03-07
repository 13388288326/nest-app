package com.java.admin.test;

import com.java.admin.service.PatientService;
import com.java.admin.service.SysDictService;
import com.java.admin.vo.PatientVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysDictPojoTest {
    @Autowired
    SysDictService sysDictService;

    @Autowired
    PatientService patientService;
    @Test
    void sx(){
//        sysDictService.refreshCache();
        PatientVo vo = patientService.getDetail("1");
        System.out.println(vo.toString());
    }
}
