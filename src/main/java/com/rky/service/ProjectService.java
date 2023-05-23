package com.rky.service;

import com.rky.pojo.PageBean;
import com.rky.pojo.Project;

import java.util.List;

public interface ProjectService {
    void add(Project project);

    PageBean selectPage(Integer start, Integer pageSize);

    PageBean selectPageClass(Integer start, Integer pageSize, Integer classId);

    void update(Project project);

    void delete(List<Integer> ids);
}
