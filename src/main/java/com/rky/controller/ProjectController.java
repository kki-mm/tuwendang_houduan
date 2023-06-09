package com.rky.controller;

import com.rky.pojo.PageBean;
import com.rky.pojo.Project;
import com.rky.pojo.Result;
import com.rky.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /*新建项目*/
    @PostMapping("projects/add")
    public Result add(@RequestBody Project project){
        projectService.add(project);

        return Result.success();  //需不需要返回新建的项目id呢？？
    }



    /*新建员工后*/
    /*
    *   1. add 人员项目表 project_person
    *   2. add 项目审批人员表 project_approve
    * */



    /*分页查询所有项目*/
    @GetMapping("projects/selectPage")
    public Result selectPage(Integer start,Integer pageSize){

        PageBean pageBean = projectService.selectPage(start,pageSize);
        return Result.success(pageBean);
    }

    /*分页查询工作区项目 {id} id 1  工作区 id 2 非工作区*/
    //class id 1 : 工作区 0：归档区   默认查询工作区 classId 默认为 1
    @GetMapping("/projects/selectPageClass")
    public Result selectPageClass(Integer start,Integer pageSize,@RequestParam(defaultValue = "1") Integer classId){
        PageBean pageBean = projectService.selectPageClass(start,pageSize,classId);
        return Result.success(pageBean);
    }

    /*根据id 修改项目*/
    @PutMapping("/projects/update")
    public Result update(@RequestBody Project project){

        projectService.update(project);
        return Result.success();
    }
    /*
    * 修改项目限定不能修改项目成员，修改审批人员，添加按钮来增加项目成员。
    * 1.更新项目成员表
    * 2.更新审批人表
    * */

    /*根据id 删除项目 多选*/
    @DeleteMapping("projects/delete/{ids}")
    public Result delete(@PathVariable List<String> ids){
        log.info("根据id删除部门：{}",ids);
        projectService.delete(ids);
        return Result.success();
    }





}
