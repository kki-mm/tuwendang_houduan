package com.rky.controller;

import com.rky.pojo.Result;
import com.rky.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private UploadService uploadService;


    public Result loadFile(MultipartFile file) throws IOException {
        //1. 获取文件的后缀
        String originalFilename = file.getOriginalFilename();

        int index = originalFilename.lastIndexOf('.');

        String fileClass = originalFilename.substring(index);  //.pdf

        //log.info(fileClass);

        //2.获取uuid 拼接保存名称
        String uuid = UUID.randomUUID().toString();

        //log.info(uuid);
        //3.文件保存地址逻辑
        String fileSavePath = "E:\\rky\\FILESAVE\\";

        String fileSaveEndPath = fileSavePath+uuid+fileClass;
        //4.文件格式转换（是否只要上传就转  需提供flag）

        //5.文件去水印

        //6.文件保存
        file.transferTo(new File(fileSaveEndPath));


        return Result.success();
    }
}
