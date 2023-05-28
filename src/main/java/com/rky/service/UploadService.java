package com.rky.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface UploadService {
    String getClass(MultipartFile file);

    void convertPdf(String fileClassName, InputStream inputStream, String fileSavePathPdf);
}
