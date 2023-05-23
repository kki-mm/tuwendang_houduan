package com.rky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rky.mapper.ProjectMapper;
import com.rky.pojo.PageBean;
import com.rky.pojo.Project;
import com.rky.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void add(Project project) {
        project.setUpdateTime(LocalDateTime.now());
        project.setCreateTime(LocalDateTime.now());
        projectMapper.add(project);
    }

    @Override
    public PageBean selectPage(Integer start, Integer pageSize) {
        PageHelper.startPage(start,pageSize);
        List<Project> projectList = projectMapper.selectAll();
        Page<Project>projectPage = (Page<Project>) projectList;
        return new PageBean(projectPage.getTotal(),projectPage.getResult());

    }

    @Override
    public PageBean selectPageClass(Integer start, Integer pageSize, Integer classId) {
        PageHelper.startPage(start,pageSize);
        List<Project> projectList = projectMapper.selectClass(classId);
        Page<Project>projectPage = (Page<Project>) projectList;
        return new PageBean(projectPage.getTotal(),projectPage.getResult());
    }

    @Override
    public void update(Project project) {
        project.setUpdateTime(LocalDateTime.now());
        projectMapper.update(project);
    }

    @Override
    public void delete(List<Integer> ids) {
        projectMapper.delete(ids);
    }
}
