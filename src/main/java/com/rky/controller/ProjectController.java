package com.rky.controller;

import com.rky.pojo.Project;
import com.rky.pojo.Result;
import com.rky.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /*新建项目*/
    @PostMapping("project/add")
    public Result add(@RequestBody Project project){
        projectService.add(project);
        return Result.success();  //需不需要返回新建的项目id呢？？
    }

    /*分页查询所有项目*/


    /*分页查询工作区项目 {id} id 1  工作区 id 2 非工作区*/


    /*根据id 修改项目*/


    /*根据id 删除项目*/



}
