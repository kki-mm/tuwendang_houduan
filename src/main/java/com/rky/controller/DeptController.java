package com.rky.controller;

import com.rky.pojo.Dept;
import com.rky.pojo.Result;
import com.rky.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    /*请求所有部门*/

    @GetMapping("/depts/select")
    public Result selectAll(){
        List<Dept> depts = deptService.selectAll();
        log.info("查询部门列表");
        return Result.success(depts);
    }


    /*修改部门信息 根据id*/


    /*新建部门*/


    /*删除部门*/





}
