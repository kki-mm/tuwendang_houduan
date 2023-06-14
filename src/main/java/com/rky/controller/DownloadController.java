package com.rky.controller;

//import com.alibaba.fastjson.util.IOUtils;
import org.apache.commons.io.IOUtils;
import com.rky.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

//import org.apache.commons.io.IOUtils;

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


    @GetMapping("/preview")
    public void preview(String path,HttpServletResponse response)  {
        try{
            ServletOutputStream outputStream = response.getOutputStream();
            InputStream in = new FileInputStream(new File(path));  //pdf输入流
            int i = IOUtils.copy(in,outputStream);
            in.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}



