package com.rky.service.impl;
import java.io.*;

import com.rky.mapper.DownloadMapper;
import com.rky.service.DeptService;
import com.rky.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    DownloadMapper downloadMapper;

    @Override
    public String downloadFile(String filePath, HttpServletRequest request, HttpServletResponse response) {
        //设置文件路径
        String path = "E://rky//FILESAVE//技术部//2023//JUNE//a5469deft//燃烧控制室//设备清单//pdf//0336579c-b466-483f-88a5-2af38d465412.pdf";
        //log.info(path);
        //log.info(filePath);
        File file = new File(path);
        //获取文件名称
        String fileName = file.getName();
      //  log.info("fileName:{}",fileName);

        //判断文件是否存在
        if (file.exists()) {
            log.info("file exists");
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                file.delete();
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            log.info("file no exits");
        }

        return "下载失败";
    }
}
