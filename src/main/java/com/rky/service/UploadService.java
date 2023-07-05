package com.rky.service;

import com.rky.pojo.Filee;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


public interface UploadService {
    String getClass(MultipartFile file);

    void convertPdf(String fileClassName, InputStream inputStream, String fileSavePathPdf);

    String createFolder(String workPath,String depart,String projectId,String projectName,String room,String fileClass);




    void add(String fileSizeDanwei, String fileClassName, String fileSavePathSrc, String fileSavePathPdf, Filee filee);

    long getSize(MultipartFile file);


    String getSizeDanwei(long fileSize);


}
