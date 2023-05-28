package com.rky.controller;

import com.rky.pojo.Result;
import com.rky.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private UploadService uploadService;


    @PostMapping("/upload")
    //需要给一个flag ,是否需要转pdf
    public Result loadFile(MultipartFile file,boolean need_pdf)throws Exception{

        //1. 得到后缀名称
        String fileClassName = uploadService.getClass(file);

        //2.设计文件保存地址与名字
        //获取uuid 拼接保存名称
        String uuid = UUID.randomUUID().toString();
        //文件保存地址逻辑
        String fileSavePath = "E:\\rky\\FILESAVE\\";
        //源文件保存地址
        String fileSavePathSrc = fileSavePath+uuid+fileClassName;
        //pdf 文件保存地址
        String fileSavePathPdf = fileSavePath+uuid+".pdf";


        //3.进行pdf文件格式转换并保存
        //param (1) pdf 保存路径 （2）源文件路径 这个有问题 尝试输入流形式（3）源文件格式类型
        if(need_pdf) {
            InputStream inputStream = file.getInputStream();
            uploadService.convertPdf(fileClassName, inputStream, fileSavePathPdf);
            inputStream.close();
        }
        //3.源文件保存
        file.transferTo(new File(fileSavePathSrc));

        //4.更新文件--项目 表


        //5.想办法返回在线预览地址

        return Result.success();
    }

    /*
    * 文件上传后进行操作
    * 1.
    * */
}
