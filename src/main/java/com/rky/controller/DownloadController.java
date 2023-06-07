package com.rky.controller;

import com.rky.pojo.Result;
import com.rky.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@RestController
@Slf4j
public class DownloadController {

    @Autowired
    DownloadService downloadService;

    @GetMapping("/download")
    public void download(String path, HttpServletResponse response) {
        try {
            File file = new File(path);
            log.info(file.getPath());
            String filename = file.getName();
            if(!file.exists()){
                log.info("file exits");
                //return Result.error("文件不存在");
            }
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
            log.info("文件后缀名：" + ext);

            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       // return Result.success("下载成功");
    }

}
