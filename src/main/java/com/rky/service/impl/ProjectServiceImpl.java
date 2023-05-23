package com.rky.service.impl;

import com.rky.mapper.ProjectMapper;
import com.rky.pojo.Project;
import com.rky.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void add(Project project) {
        project.setUpdateTime(LocalDateTime.now());
        projectMapper.add(project);
    }
}
