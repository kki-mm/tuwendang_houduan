package com.rky.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;

public interface UploadService {
    String getClass(MultipartFile file);

    void convertPdf(String fileClassName, InputStream inputStream, String fileSavePathPdf);

    String createFolder(String workPath,String depart,String projectId,String room,String fileClass);
}
