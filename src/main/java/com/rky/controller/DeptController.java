package com.rky.controller;

import com.rky.pojo.Dept;
import com.rky.pojo.Result;
import com.rky.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/depts/update")
    public Result updata(@RequestBody Dept dept){
        deptService.updata(dept);
        return  Result.success();
    }

    /*新建部门*/

    @PostMapping("/depts/add")
    public Result add(@RequestBody Dept dept){

        deptService.add(dept);
        return  Result.success();
    }

    /*多选删除部门  删除单个一样可以使用*/







}
