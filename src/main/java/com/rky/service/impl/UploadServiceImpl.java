package com.rky.service.impl;

import com.rky.mapper.UploadMapper;
import com.rky.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
   @Autowired
    private UploadMapper uploadMapper;

}
