package com.java.admin.controller;

import com.java.admin.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Api(tags = "附件上传")
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/image")
    @ApiOperation("上传图片")
    public R uploadImage(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        String fileRootPath = "/Users/junbaba/Desktop/个人/nest-app/src/main/resources/file/";
        File saveFile = new File(fileRootPath + filename);
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success();
    }
}
