package com.rky.service.impl;

import com.rky.mapper.UploadMapper;
import com.rky.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import com.rky.utils.Word2PdfUtil;

import static com.rky.utils.Word2PdfUtil.doc2pdf;
import static com.rky.utils.cad2pdf2.Dwg2Pdf;
import static com.rky.utils.excel2pdf.excel2pdf;

@Slf4j
@Service
public class UploadServiceImpl implements UploadService {
   @Autowired
    private UploadMapper uploadMapper;

    @Override
    public String getClass(MultipartFile file) {

         //1.得到原名
        String originalFilename = file.getOriginalFilename();
        //2.找到最后一个  .
        int index = originalFilename.lastIndexOf('.');
        //3.取出后缀
        String fileClass = originalFilename.substring(index);  //.pdf

        return fileClass;
    }

    @Override
    //dwg dxf
    public void convertPdf(String fileClassName, InputStream inputStream, String fileSavePathPdf){

        log.info("转换文档类型为：{}",fileClassName);
            //1. 判断文件类型 根据文件类型调用不同的格式转换函数
        if(fileClassName.contains("doc")){
            log.info("start to convert word to pdf");
            //调用 doc to pdf
            doc2pdf(inputStream,fileSavePathPdf);
        } else if (fileClassName.contains("xls")) {
            //调用 excel to pdf
            log.info("start to convert excel to pdf");
            excel2pdf(inputStream,fileSavePathPdf);
        } else if (fileClassName.contains("dwg")||fileClassName.contains("dxf")||fileClassName.contains("dws")||fileClassName.contains("dt")) {
            //调用 cad to pdf   有个问题：cad 文件不只包含这个格式
            log.info("start to convert cad to pdf");
            Dwg2Pdf(inputStream,fileSavePathPdf);
        }
    }
}




