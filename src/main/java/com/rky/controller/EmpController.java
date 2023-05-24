package com.rky.controller;

import com.rky.pojo.Emp;
import com.rky.pojo.PageBean;
import com.rky.pojo.Result;
import com.rky.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    /*得到所有员工*/
    @GetMapping("/emps/select")
    public Result selectAll(){
        log.info("查询所有员工");
        List<Emp> empList = empService.selectAll();
        return Result.success(empList);
    }

    /*分页得到所有员工*/
    @GetMapping("emps/selectPage")
    public Result selectPage(Integer start,Integer pageSize){
        PageBean pageBean = empService.selectPage(start,pageSize);
        return  Result.success(pageBean);
    }


    /*修改用户信息  与修改密码一起*/


    /*新建员工*/


    /*删除员工*/





}
