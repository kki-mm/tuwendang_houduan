package com.rky.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DownloadService {
    String downloadFile(String filePath, HttpServletRequest request, HttpServletResponse response);
}
