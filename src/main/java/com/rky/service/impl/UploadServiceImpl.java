package com.rky.service.impl;

import com.rky.mapper.UploadMapper;
import com.rky.pojo.Filee;
import com.rky.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        log.info("原名,{}",originalFilename);
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

    @Override
    public String createFolder(String workPath, String depart, String projectId,String projectName, String room, String fileClass) {
        String depart_name = depart;//部门名称
        LocalDate localDate = LocalDate.now();
        String Year = String.valueOf(localDate.getYear());
        String Month = String.valueOf(localDate.getMonth());
        String project = projectId+" "+projectName;//项目id
        String roomName = room;//室
        String className = fileClass;//资料类型
        String src_path = workPath+"//"+depart_name+"//"+Year+"//"+Month+"//"+project+"//"+roomName+"//"+fileClass+"//"+"src";
        String pdf_path = workPath+"//"+depart_name+"//"+Year+"//"+Month+"//"+project+"//"+roomName+"//"+fileClass+"//"+"pdf";
        String returnPath = workPath+"//"+depart_name+"//"+Year+"//"+Month+"//"+project+"//"+roomName+"//"+fileClass;
        File file = new File(src_path);
        File file2 = new File(pdf_path);
        log.info("src地址,{}",src_path);
        log.info("pdf地址,{}",pdf_path);
        file.mkdirs();
        file2.mkdirs();
        return returnPath;
    }

    @Override
    public void add(String fileSizeDanwei, String fileClassName, String fileSavePathSrc, String fileSavePathPdf, Filee filee) {
        filee.setFileSizeSrc(fileSizeDanwei);
        filee.setFileType(fileClassName);
        filee.setFilePathSrc(fileSavePathSrc);
        if(fileClassName.contains("doc")||fileClassName.contains("xls")||fileClassName.contains("dwg")||fileClassName.contains("dxf")||fileClassName.contains("dws")||fileClassName.contains("dt")) {
            filee.setFilePathPdf(fileSavePathPdf);
        }else{
            filee.setFilePathPdf("无");
        }
        filee.setUploadTime(LocalDateTime.now());
        filee.setUpdateTime(LocalDateTime.now());
        Double creatorworkhour =filee.creatorWorkHour;
        Double difficultydegree =filee.difficultyDegree;
        filee.setContributeDegree(difficultydegree*creatorworkhour);
        uploadMapper.add(filee);
    }



    @Override
    public long getSize(MultipartFile file) {
        long fileSize = file.getSize();
        log.info("源文件大小,{}",fileSize);
        return fileSize;
    }

    @Override
    public String getSizeDanwei(long fileSize) {
         String fileSizeDanwei = null;
        DecimalFormat df = new DecimalFormat("#.00");
        if (fileSize < 1024) {
            fileSizeDanwei = df.format((double) fileSize) + "B";
        }
        else if (fileSize < 1048576) {
            fileSizeDanwei = df.format((double) fileSize / 1024) + "K";
        }
        else if (fileSize < 1073741824) {
            fileSizeDanwei = df.format((double) fileSize / 1048576) + "M";
        }
        else {
            fileSizeDanwei = df.format((double) fileSize/ 1073741824) + "G";
        }
        log.info("源文件大小带单位,{}",fileSizeDanwei);
        return fileSizeDanwei;






      
    }


}




